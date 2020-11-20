// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The HealthcareRelation model. */
@Fluent
public final class HealthcareRelation {
    /*
     * Type of relation. Examples include: `DosageOfMedication` or
     * 'FrequencyOfMedication', etc.
     */
    @JsonProperty(value = "relationType", required = true)
    private String relationType;

    /*
     * If true the relation between the entities is bidirectional, otherwise
     * directionality is source to target.
     */
    @JsonProperty(value = "bidirectional", required = true)
    private boolean bidirectional;

    /*
     * Reference link to the source entity.
     */
    @JsonProperty(value = "source", required = true)
    private String source;

    /*
     * Reference link to the target entity.
     */
    @JsonProperty(value = "target", required = true)
    private String target;

    /**
     * Get the relationType property: Type of relation. Examples include: `DosageOfMedication` or
     * 'FrequencyOfMedication', etc.
     *
     * @return the relationType value.
     */
    public String getRelationType() {
        return this.relationType;
    }

    /**
     * Set the relationType property: Type of relation. Examples include: `DosageOfMedication` or
     * 'FrequencyOfMedication', etc.
     *
     * @param relationType the relationType value to set.
     * @return the HealthcareRelation object itself.
     */
    public HealthcareRelation setRelationType(String relationType) {
        this.relationType = relationType;
        return this;
    }

    /**
     * Get the bidirectional property: If true the relation between the entities is bidirectional, otherwise
     * directionality is source to target.
     *
     * @return the bidirectional value.
     */
    public boolean isBidirectional() {
        return this.bidirectional;
    }

    /**
     * Set the bidirectional property: If true the relation between the entities is bidirectional, otherwise
     * directionality is source to target.
     *
     * @param bidirectional the bidirectional value to set.
     * @return the HealthcareRelation object itself.
     */
    public HealthcareRelation setBidirectional(boolean bidirectional) {
        this.bidirectional = bidirectional;
        return this;
    }

    /**
     * Get the source property: Reference link to the source entity.
     *
     * @return the source value.
     */
    public String getSource() {
        return this.source;
    }

    /**
     * Set the source property: Reference link to the source entity.
     *
     * @param source the source value to set.
     * @return the HealthcareRelation object itself.
     */
    public HealthcareRelation setSource(String source) {
        this.source = source;
        return this;
    }

    /**
     * Get the target property: Reference link to the target entity.
     *
     * @return the target value.
     */
    public String getTarget() {
        return this.target;
    }

    /**
     * Set the target property: Reference link to the target entity.
     *
     * @param target the target value to set.
     * @return the HealthcareRelation object itself.
     */
    public HealthcareRelation setTarget(String target) {
        this.target = target;
        return this;
    }
}