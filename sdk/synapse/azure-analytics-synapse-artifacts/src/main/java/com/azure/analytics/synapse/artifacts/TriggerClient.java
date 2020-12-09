// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts;

import com.azure.analytics.synapse.artifacts.implementation.TriggersImpl;
import com.azure.analytics.synapse.artifacts.models.CloudErrorException;
import com.azure.analytics.synapse.artifacts.models.TriggerResource;
import com.azure.analytics.synapse.artifacts.models.TriggerSubscriptionOperationStatus;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/** Initializes a new instance of the synchronous ArtifactsClient type. */
@ServiceClient(builder = ArtifactsClientBuilder.class)
public final class TriggerClient {
    private final TriggersImpl serviceClient;

    /**
     * Initializes an instance of Triggers client.
     *
     * @param serviceClient the service client implementation.
     */
    TriggerClient(TriggersImpl serviceClient) {
        this.serviceClient = serviceClient;
    }

    /**
     * Lists triggers.
     *
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of trigger resources.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<TriggerResource> getTriggersByWorkspace() {
        return this.serviceClient.getTriggersByWorkspace();
    }

    /**
     * Lists triggers.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of trigger resources.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<TriggerResource> getTriggersByWorkspace(Context context) {
        return this.serviceClient.getTriggersByWorkspace(context);
    }

    /**
     * Creates or updates a trigger.
     *
     * @param triggerName The trigger name.
     * @param trigger Trigger resource definition.
     * @param ifMatch ETag of the trigger entity. Should only be specified for update, for which it should match
     *     existing entity or can be * for unconditional update.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return trigger resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public TriggerResource createOrUpdateTrigger(String triggerName, TriggerResource trigger, String ifMatch) {
        return this.serviceClient.createOrUpdateTrigger(triggerName, trigger, ifMatch);
    }

    /**
     * Creates or updates a trigger.
     *
     * @param triggerName The trigger name.
     * @param trigger Trigger resource definition.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return trigger resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public TriggerResource createOrUpdateTrigger(String triggerName, TriggerResource trigger) {
        return this.serviceClient.createOrUpdateTrigger(triggerName, trigger);
    }

    /**
     * Creates or updates a trigger.
     *
     * @param triggerName The trigger name.
     * @param trigger Trigger resource definition.
     * @param ifMatch ETag of the trigger entity. Should only be specified for update, for which it should match
     *     existing entity or can be * for unconditional update.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return trigger resource type.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<TriggerResource> createOrUpdateTriggerWithResponse(
            String triggerName, TriggerResource trigger, String ifMatch, Context context) {
        return this.serviceClient.createOrUpdateTriggerWithResponse(triggerName, trigger, ifMatch, context);
    }

    /**
     * Gets a trigger.
     *
     * @param triggerName The trigger name.
     * @param ifNoneMatch ETag of the trigger entity. Should only be specified for get. If the ETag matches the existing
     *     entity tag, or if * was provided, then no content will be returned.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a trigger.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public TriggerResource getTrigger(String triggerName, String ifNoneMatch) {
        return this.serviceClient.getTrigger(triggerName, ifNoneMatch);
    }

    /**
     * Gets a trigger.
     *
     * @param triggerName The trigger name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a trigger.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public TriggerResource getTrigger(String triggerName) {
        return this.serviceClient.getTrigger(triggerName);
    }

    /**
     * Gets a trigger.
     *
     * @param triggerName The trigger name.
     * @param ifNoneMatch ETag of the trigger entity. Should only be specified for get. If the ETag matches the existing
     *     entity tag, or if * was provided, then no content will be returned.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a trigger.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<TriggerResource> getTriggerWithResponse(String triggerName, String ifNoneMatch, Context context) {
        return this.serviceClient.getTriggerWithResponse(triggerName, ifNoneMatch, context);
    }

    /**
     * Deletes a trigger.
     *
     * @param triggerName The trigger name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void deleteTrigger(String triggerName) {
        this.serviceClient.deleteTrigger(triggerName);
    }

    /**
     * Deletes a trigger.
     *
     * @param triggerName The trigger name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> deleteTriggerWithResponse(String triggerName, Context context) {
        return this.serviceClient.deleteTriggerWithResponse(triggerName, context);
    }

    /**
     * Subscribe event trigger to events.
     *
     * @param triggerName The trigger name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return defines the response of a trigger subscription operation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public TriggerSubscriptionOperationStatus subscribeTriggerToEvents(String triggerName) {
        return this.serviceClient.subscribeTriggerToEvents(triggerName);
    }

    /**
     * Subscribe event trigger to events.
     *
     * @param triggerName The trigger name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return defines the response of a trigger subscription operation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<TriggerSubscriptionOperationStatus> subscribeTriggerToEventsWithResponse(
            String triggerName, Context context) {
        return this.serviceClient.subscribeTriggerToEventsWithResponse(triggerName, context);
    }

    /**
     * Get a trigger's event subscription status.
     *
     * @param triggerName The trigger name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a trigger's event subscription status.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public TriggerSubscriptionOperationStatus getEventSubscriptionStatus(String triggerName) {
        return this.serviceClient.getEventSubscriptionStatus(triggerName);
    }

    /**
     * Get a trigger's event subscription status.
     *
     * @param triggerName The trigger name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a trigger's event subscription status.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<TriggerSubscriptionOperationStatus> getEventSubscriptionStatusWithResponse(
            String triggerName, Context context) {
        return this.serviceClient.getEventSubscriptionStatusWithResponse(triggerName, context);
    }

    /**
     * Unsubscribe event trigger from events.
     *
     * @param triggerName The trigger name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return defines the response of a trigger subscription operation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public TriggerSubscriptionOperationStatus unsubscribeTriggerFromEvents(String triggerName) {
        return this.serviceClient.unsubscribeTriggerFromEvents(triggerName);
    }

    /**
     * Unsubscribe event trigger from events.
     *
     * @param triggerName The trigger name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return defines the response of a trigger subscription operation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<TriggerSubscriptionOperationStatus> unsubscribeTriggerFromEventsWithResponse(
            String triggerName, Context context) {
        return this.serviceClient.unsubscribeTriggerFromEventsWithResponse(triggerName, context);
    }

    /**
     * Starts a trigger.
     *
     * @param triggerName The trigger name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void startTrigger(String triggerName) {
        this.serviceClient.startTrigger(triggerName);
    }

    /**
     * Starts a trigger.
     *
     * @param triggerName The trigger name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> startTriggerWithResponse(String triggerName, Context context) {
        return this.serviceClient.startTriggerWithResponse(triggerName, context);
    }

    /**
     * Stops a trigger.
     *
     * @param triggerName The trigger name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void stopTrigger(String triggerName) {
        this.serviceClient.stopTrigger(triggerName);
    }

    /**
     * Stops a trigger.
     *
     * @param triggerName The trigger name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudErrorException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> stopTriggerWithResponse(String triggerName, Context context) {
        return this.serviceClient.stopTriggerWithResponse(triggerName, context);
    }
}