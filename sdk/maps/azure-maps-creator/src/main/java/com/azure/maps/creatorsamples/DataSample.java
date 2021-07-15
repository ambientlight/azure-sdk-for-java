// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.maps.creatorsamples;

import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpResponse;
import reactor.core.publisher.Mono;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.util.Context;
import com.azure.maps.creator.CreatorManager;
import com.azure.core.management.AzureEnvironment;
import com.azure.maps.creator.models.Datas;
import com.azure.maps.creator.models.GeoJsonFeatureCollection;
import com.azure.maps.creator.models.LongRunningOperationResult;
import com.azure.maps.creator.models.UploadDataFormat;
import com.azure.maps.creator.models.LroStatus;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.azure.core.http.rest.Response;

public class DataSample {
    static void uploadAndThenDeleteResource(Datas dataClient, Object resourceContent, UploadDataFormat dataFormat){
        try {
            var uploadPreviewResult = dataClient.uploadPreview(dataFormat, resourceContent);
            var operationId = uploadPreviewResult.operationId();
            var status = uploadPreviewResult.status();

            Response<LongRunningOperationResult> result = null;
            if(status != LroStatus.RUNNING){
                result = dataClient.getOperationPreviewWithResponse(operationId, Context.NONE);
            } else {
                // FIXME: When uploading DWG, I am noticing upload preview returning pre-maturily with LRO still in progress
                // and seemingly never completes.
                while(status == LroStatus.RUNNING){
                    TimeUnit.SECONDS.sleep(1);
                    result = dataClient.getOperationPreviewWithResponse(operationId, Context.NONE);
                    MapsCommon.print(result.getValue().innerModel());
                    status = result.getValue().status();
                }
            }

            var resourceLocation = result.getHeaders().getValue("Resource-Location");
            if(resourceLocation == null){
                throw new Exception("Resource-Location is not available in header. (LRO still running?)");
            }

            var pattern = Pattern.compile("[0-9A-Fa-f\\-]{36}");
            var match = pattern.matcher(resourceLocation);
            var matches = match.find();
            if(!matches){
                throw new Exception("Unable to extract resource uuid from resource location.");
            }

            var udid = match.group(0);
            dataClient.deletePreview(udid);
        } catch (IOException err) {
            System.out.println(err);
        } catch (Exception err) {
            System.out.println(err);
        } finally {
            // finalization
        }
    }

    public static void main(String[] args)  {
        var clientIdPolicy = new HttpPipelinePolicy(){
            @Override
            public Mono<HttpResponse> process(HttpPipelineCallContext context, HttpPipelineNextPolicy next) {
                return Mono.defer(() -> {
                    context.getHttpRequest().setHeader("x-ms-client-id", System.getenv("CLIENT_ID"));
                    return next.process();
                });
            }
        };

        var subscriptionKeyPolicy = new HttpPipelinePolicy(){
            @Override
            public Mono<HttpResponse> process(HttpPipelineCallContext context, HttpPipelineNextPolicy next) {
                return Mono.defer(() -> {
                    context.getHttpRequest().setUrl(context.getHttpRequest().getUrl().toString() + "&subscription-key=" + System.getenv("SUBSCRIPTION_KEY"));
                    return next.process();
                });
            }
        };

        var defaultCreds = new DefaultAzureCredentialBuilder().build();
        Datas dataClient = CreatorManager
            .configure()
            .withPolicy(subscriptionKeyPolicy)
            .authenticate(defaultCreds, new AzureProfile(new AzureEnvironment(new HashMap<String, String>() {{
                put("managementEndpointUrl", "https://atlas.microsoft.com");
            }})))
            .datas();

        try {
            GeoJsonFeatureCollection feature = new ObjectMapper().readValue(MapsCommon.getResourceURL("/data_sample_upload.json"), GeoJsonFeatureCollection.class);
            uploadAndThenDeleteResource(dataClient, feature, UploadDataFormat.GEOJSON);

            //FIXME: Below never completes (LRO returns with running state)
            //InputStream dwgStream = MapsCommon.getResource("/data_sample_upload.zip");
            //uploadAndThenDeleteResource(dataClient, dwgStream.readAllBytes(), UploadDataFormat.DWGZIPPACKAGE);
        } catch (JsonParseException err) {
            System.out.println(err);
        } catch (JsonMappingException err){
            System.out.println(err);
        } catch (IOException err) {
            System.out.println(err);
        } finally {
            //
        }

        System.out.println("DONE");
    }
}
