package com.kumuluz.ee.federation.compatibility;

import com.kumuluz.ee.federation.compatibility.model.*;
import io.smallrye.graphql.api.Deprecated;
import io.smallrye.graphql.api.federation.ComposeDirective;
import io.smallrye.graphql.api.federation.link.Import;
import io.smallrye.graphql.api.federation.link.Link;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.*;

import static io.smallrye.graphql.api.federation.link.Link.FEDERATION_SPEC_LATEST_URL;

@RequestScoped
@GraphQLApi
@Link(url = FEDERATION_SPEC_LATEST_URL, _import = {
        @Import(name = "@composeDirective"),
        @Import(name = "@external"),
        @Import(name = "@inaccessible"),
        @Import(name = "@interfaceObject"),
        @Import(name = "@key"),
        @Import(name = "@override"),
        @Import(name = "@provides"),
        @Import(name = "@requires"),
        @Import(name = "@shareable"),
        @Import(name = "@tag")
})
@Link(url = "https://myspecs.dev/myCustomDirective/v1.0", _import = {@Import(name = "@custom")})
@ComposeDirective(name = "@custom")
public class CompatibilityResource {

    @Inject
    private CompatibilityService compatibilityBean;

    @Query
    @Deprecated(reason = "Use product query instead")
    public DeprecatedProduct deprecatedProduct(@NonNull String sku, @NonNull @Name("package") String _package) {
        return compatibilityBean.getDeprecatedProduct(sku, _package);
    }

    @Query
    public Inventory inventory(@Id @NonNull String id) {
        return compatibilityBean.getInventory(id);
    }

    @Query
    public Product product(@Id @NonNull String id) {
        return compatibilityBean.getProduct(id);
    }

    @Query
    public Product product1(@NonNull String sku, @NonNull @Name("package") String _package) {
        return compatibilityBean.getProduct(sku, _package);
    }

    @Query
    public Product product2(@NonNull String sku, @NonNull @Name("variation") ProductVariation variation) {
        return compatibilityBean.getProduct(sku, variation);
    }

    @Query
    public ProductResearch productResearch(@NonNull CaseStudy study) {
        return compatibilityBean.getProductResearch(study);
    }

    @Query
    public User user(@NonNull String email) {
        return compatibilityBean.getUser(email);
    }

    @Query
    public User user1(@NonNull String email, @NonNull Integer totalProductsCreated,
                      @NonNull Integer yearsOfEmployment) {
        return compatibilityBean.getUser(email, totalProductsCreated, yearsOfEmployment);
    }
}
