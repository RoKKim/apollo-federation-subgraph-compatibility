package com.kumuluz.ee.federation.compatibility.model;

import io.smallrye.graphql.api.federation.Override;
import io.smallrye.graphql.api.federation.*;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;

@Key(fields = @FieldSet("email"))
public record User(
        @Id
        @NonNull
        @External String email,
        @Override(from = "users")
        String name,
        @External
        Integer totalProductsCreated,
        @NonNull
        @External
        Integer yearsOfEmployment,
        @Requires(fields = @FieldSet("totalProductsCreated yearsOfEmployment"))
        Integer averageProductsCreatedPerYear
) {
    public User {
        averageProductsCreatedPerYear = calculateAverageProductsCreatedPerYear(totalProductsCreated, yearsOfEmployment);
    }

    private static Integer calculateAverageProductsCreatedPerYear(Integer totalProducts, Integer years) {
        if (totalProducts != null && years != null && years != 0) {
            return Math.round(1.0f * totalProducts / years);
        } else {
            return null;
        }
    }
}
