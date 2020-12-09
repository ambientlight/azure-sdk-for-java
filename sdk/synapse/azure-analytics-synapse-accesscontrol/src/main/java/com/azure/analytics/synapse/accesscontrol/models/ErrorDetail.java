// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.accesscontrol.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The ErrorDetail model. */
@Fluent
public final class ErrorDetail {
    /*
     * The code property.
     */
    @JsonProperty(value = "code", required = true)
    private String code;

    /*
     * The message property.
     */
    @JsonProperty(value = "message", required = true)
    private String message;

    /*
     * The target property.
     */
    @JsonProperty(value = "target")
    private String target;

    /**
     * Get the code property: The code property.
     *
     * @return the code value.
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Set the code property: The code property.
     *
     * @param code the code value to set.
     * @return the ErrorDetail object itself.
     */
    public ErrorDetail setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get the message property: The message property.
     *
     * @return the message value.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Set the message property: The message property.
     *
     * @param message the message value to set.
     * @return the ErrorDetail object itself.
     */
    public ErrorDetail setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get the target property: The target property.
     *
     * @return the target value.
     */
    public String getTarget() {
        return this.target;
    }

    /**
     * Set the target property: The target property.
     *
     * @param target the target value to set.
     * @return the ErrorDetail object itself.
     */
    public ErrorDetail setTarget(String target) {
        this.target = target;
        return this;
    }
}