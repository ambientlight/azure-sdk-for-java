/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cdn.v2020_09_01;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The WafMetricsResponseSeriesItemDataItem model.
 */
public class WafMetricsResponseSeriesItemDataItem {
    /**
     * The dateTimeProperty property.
     */
    @JsonProperty(value = "dateTime")
    private DateTime dateTimeProperty;

    /**
     * The value property.
     */
    @JsonProperty(value = "value")
    private Double value;

    /**
     * Get the dateTimeProperty value.
     *
     * @return the dateTimeProperty value
     */
    public DateTime dateTimeProperty() {
        return this.dateTimeProperty;
    }

    /**
     * Set the dateTimeProperty value.
     *
     * @param dateTimeProperty the dateTimeProperty value to set
     * @return the WafMetricsResponseSeriesItemDataItem object itself.
     */
    public WafMetricsResponseSeriesItemDataItem withDateTimeProperty(DateTime dateTimeProperty) {
        this.dateTimeProperty = dateTimeProperty;
        return this;
    }

    /**
     * Get the value value.
     *
     * @return the value value
     */
    public Double value() {
        return this.value;
    }

    /**
     * Set the value value.
     *
     * @param value the value value to set
     * @return the WafMetricsResponseSeriesItemDataItem object itself.
     */
    public WafMetricsResponseSeriesItemDataItem withValue(Double value) {
        this.value = value;
        return this;
    }

}