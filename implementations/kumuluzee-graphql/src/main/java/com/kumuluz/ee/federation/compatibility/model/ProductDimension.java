package com.kumuluz.ee.federation.compatibility.model;

import io.smallrye.graphql.api.federation.Inaccessible;
import io.smallrye.graphql.api.federation.Shareable;

@Shareable
public record ProductDimension(
        String size,
        Float weight,
        @Inaccessible
        String unit
) {
}
