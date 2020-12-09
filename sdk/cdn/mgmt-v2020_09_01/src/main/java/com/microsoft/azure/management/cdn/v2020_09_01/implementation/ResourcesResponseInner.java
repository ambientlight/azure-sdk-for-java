/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cdn.v2020_09_01.implementation;

import java.util.List;
import com.microsoft.azure.management.cdn.v2020_09_01.ResourcesResponseEndpointsItem;
import com.microsoft.azure.management.cdn.v2020_09_01.ResourcesResponseCustomDomainsItem;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Resources Response.
 */
public class ResourcesResponseInner {
    /**
     * The endpoints property.
     */
    @JsonProperty(value = "endpoints")
    private List<ResourcesResponseEndpointsItem> endpoints;

    /**
     * The customDomains property.
     */
    @JsonProperty(value = "customDomains")
    private List<ResourcesResponseCustomDomainsItem> customDomains;

    /**
     * Get the endpoints value.
     *
     * @return the endpoints value
     */
    public List<ResourcesResponseEndpointsItem> endpoints() {
        return this.endpoints;
    }

    /**
     * Set the endpoints value.
     *
     * @param endpoints the endpoints value to set
     * @return the ResourcesResponseInner object itself.
     */
    public ResourcesResponseInner withEndpoints(List<ResourcesResponseEndpointsItem> endpoints) {
        this.endpoints = endpoints;
        return this;
    }

    /**
     * Get the customDomains value.
     *
     * @return the customDomains value
     */
    public List<ResourcesResponseCustomDomainsItem> customDomains() {
        return this.customDomains;
    }

    /**
     * Set the customDomains value.
     *
     * @param customDomains the customDomains value to set
     * @return the ResourcesResponseInner object itself.
     */
    public ResourcesResponseInner withCustomDomains(List<ResourcesResponseCustomDomainsItem> customDomains) {
        this.customDomains = customDomains;
        return this;
    }

}