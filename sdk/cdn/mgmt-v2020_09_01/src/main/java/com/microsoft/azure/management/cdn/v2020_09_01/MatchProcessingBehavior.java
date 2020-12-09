/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cdn.v2020_09_01;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for MatchProcessingBehavior.
 */
public final class MatchProcessingBehavior extends ExpandableStringEnum<MatchProcessingBehavior> {
    /** Static value Continue for MatchProcessingBehavior. */
    public static final MatchProcessingBehavior CONTINUE = fromString("Continue");

    /** Static value Stop for MatchProcessingBehavior. */
    public static final MatchProcessingBehavior STOP = fromString("Stop");

    /**
     * Creates or finds a MatchProcessingBehavior from its string representation.
     * @param name a name to look for
     * @return the corresponding MatchProcessingBehavior
     */
    @JsonCreator
    public static MatchProcessingBehavior fromString(String name) {
        return fromString(name, MatchProcessingBehavior.class);
    }

    /**
     * @return known MatchProcessingBehavior values
     */
    public static Collection<MatchProcessingBehavior> values() {
        return values(MatchProcessingBehavior.class);
    }
}