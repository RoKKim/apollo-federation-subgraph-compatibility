package com.kumuluz.ee.federation.compatibility.model;

import io.smallrye.graphql.api.federation.FieldSet;
import io.smallrye.graphql.api.federation.InterfaceObject;
import io.smallrye.graphql.api.federation.Key;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;

import java.util.List;

@InterfaceObject
@Key(fields = @FieldSet("id"), resolvable = true)
public record Inventory(
        @Id
        @NonNull
        String id,
        @NonNull
        List<@NonNull DeprecatedProduct> deprecatedProducts
) {
}
