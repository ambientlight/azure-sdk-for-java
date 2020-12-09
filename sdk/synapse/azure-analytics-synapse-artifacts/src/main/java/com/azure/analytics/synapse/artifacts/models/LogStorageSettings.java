// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

/** Log storage settings. */
@Fluent
public final class LogStorageSettings {
    /*
     * Log storage linked service reference.
     */
    @JsonProperty(value = "linkedServiceName", required = true)
    private LinkedServiceReference linkedServiceName;

    /*
     * The path to storage for storing detailed logs of activity execution.
     * Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "path")
    private Object path;

    /*
     * Log storage settings.
     */
    @JsonIgnore private Map<String, Object> additionalProperties;

    /**
     * Get the linkedServiceName property: Log storage linked service reference.
     *
     * @return the linkedServiceName value.
     */
    public LinkedServiceReference getLinkedServiceName() {
        return this.linkedServiceName;
    }

    /**
     * Set the linkedServiceName property: Log storage linked service reference.
     *
     * @param linkedServiceName the linkedServiceName value to set.
     * @return the LogStorageSettings object itself.
     */
    public LogStorageSettings setLinkedServiceName(LinkedServiceReference linkedServiceName) {
        this.linkedServiceName = linkedServiceName;
        return this;
    }

    /**
     * Get the path property: The path to storage for storing detailed logs of activity execution. Type: string (or
     * Expression with resultType string).
     *
     * @return the path value.
     */
    public Object getPath() {
        return this.path;
    }

    /**
     * Set the path property: The path to storage for storing detailed logs of activity execution. Type: string (or
     * Expression with resultType string).
     *
     * @param path the path value to set.
     * @return the LogStorageSettings object itself.
     */
    public LogStorageSettings setPath(Object path) {
        this.path = path;
        return this;
    }

    /**
     * Get the additionalProperties property: Log storage settings.
     *
     * @return the additionalProperties value.
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: Log storage settings.
     *
     * @param additionalProperties the additionalProperties value to set.
     * @return the LogStorageSettings object itself.
     */
    public LogStorageSettings setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    @JsonAnySetter
    void setAdditionalProperties(String key, Object value) {
        if (additionalProperties == null) {
            additionalProperties = new HashMap<>();
        }
        additionalProperties.put(key, value);
    }
}