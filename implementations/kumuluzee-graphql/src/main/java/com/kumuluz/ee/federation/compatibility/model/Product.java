package com.kumuluz.ee.federation.compatibility.model;

import com.kumuluz.ee.federation.compatibility.directive.CustomDirective;
import io.smallrye.graphql.api.federation.FieldSet;
import io.smallrye.graphql.api.federation.Key;
import io.smallrye.graphql.api.federation.Provides;
import io.smallrye.graphql.api.federation.Tag;
import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.NonNull;

import java.util.List;

@Key(fields = @FieldSet("id"))
@Key(fields = @FieldSet("sku package"))
@Key(fields = @FieldSet("sku variation { id }"))
@CustomDirective
public record Product(
        @Id
        @NonNull
        String id,
        String sku,
        @Name("package")
        String _package,
        ProductVariation variation,
        ProductDimension dimensions,
        @Provides(fields = @FieldSet("totalProductsCreated"))
        User createdBy,
        @Tag(name = "internal")
        String notes,
        @NonNull
        List<@NonNull ProductResearch> research
) {
}
