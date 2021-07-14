// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.maps.creatorsamples;

import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.http.rest.PagedIterable;
import com.azure.maps.creator.CreatorManager;
import com.azure.maps.creator.models.Alias;
import com.azure.maps.creator.models.AliasListItem;
import com.fasterxml.jackson.core.JsonProcessingException;

import reactor.core.publisher.Mono;

import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.identity.DefaultAzureCredentialBuilder;

import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpResponse;

import java.util.HashMap;

public class AliasSample {
	public static void main(String[] args)  {
		if (args.length != 1) {
			System.out.println("Usage AliasSample.java <creatorDataItemId>");
			return;
		}

        var creatorDataItemId = args[0];
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
        Alias aliasClient = CreatorManager
            .configure()
            .withPolicy(clientIdPolicy)
            .authenticate(defaultCreds, new AzureProfile(new AzureEnvironment(new HashMap<String, String>() {{
                put("managementEndpointUrl", "https://atlas.microsoft.com");
            }})))
            .alias();

        var aliasCreateResponse = aliasClient.create();
        var aliasId = aliasCreateResponse.aliasId();
        try {
            var assignResponse = aliasClient.assign(aliasId, creatorDataItemId);
            MapsCommon.print(assignResponse.innerModel());

            var detailsResponse = aliasClient.getDetails(aliasId);
            MapsCommon.print(detailsResponse.innerModel());

            PagedIterable<AliasListItem> list = aliasClient.list();
            for (AliasListItem item : list) {
                MapsCommon.print(item.innerModel());
            }
        } catch (JsonProcessingException err) {
            System.out.println("Json Error");
            System.out.println(err);
        } catch (HttpResponseException err) {
            System.out.println("HTTP Error");
            System.out.println(err);
        } finally {
            aliasClient.delete(aliasId);
        }

        System.out.println("DONE");
	}
}
