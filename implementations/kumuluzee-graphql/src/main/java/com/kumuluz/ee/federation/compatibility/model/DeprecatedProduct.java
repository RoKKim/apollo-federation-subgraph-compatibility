package com.kumuluz.ee.federation.compatibility.model;

import io.smallrye.graphql.api.federation.FieldSet;
import io.smallrye.graphql.api.federation.Key;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.NonNull;

@Key(fields = @FieldSet("sku package"))
public record DeprecatedProduct(
        @NonNull
        String sku,
        @Name("package")
        @NonNull
        String _package,
        String reason,
        User createdBy
) {
}
