package com.kumuluz.ee.federation.compatibility;

import com.kumuluz.ee.federation.compatibility.model.*;
import jakarta.enterprise.context.RequestScoped;

import java.util.Collections;
import java.util.List;


@RequestScoped
public class CompatibilityService {

    private static final List<ProductResearch> PRODUCT_RESEARCH_LIST = List.of(
            new ProductResearch(new CaseStudy("1234", "Federation Study"), null),
            new ProductResearch(new CaseStudy("1235", "Studio Study"), null));
    private static final ProductDimension PRODUCT_DIMENSION = new ProductDimension("small", 1F, "kg");
    private static final List<User> USER_LIST = List.of(
            new User("support@apollographql.com", "Jane Smith", 1337, 10, null));
    private static final List<Product> PRODUCT_LIST = List.of(
            new Product("apollo-federation", "federation", "@apollo/federation", new ProductVariation("OSS"),
                    PRODUCT_DIMENSION, USER_LIST.get(0), null, Collections.singletonList(PRODUCT_RESEARCH_LIST.get(0))),
            new Product("apollo-studio", "studio", "", new ProductVariation("platform"), PRODUCT_DIMENSION,
                    USER_LIST.get(0), null, Collections.singletonList(PRODUCT_RESEARCH_LIST.get(1))));
    public static List<DeprecatedProduct> DEPRECATED_PRODUCT_LIST = List.of(
            new DeprecatedProduct("apollo-federation-v1", "@apollo/federation-v1", "Migrate to Federation V2",
                    USER_LIST.get(0)));
    private static final List<Inventory> INVENTORY_LIST = List.of(
            new Inventory("apollo-oss", Collections.singletonList(DEPRECATED_PRODUCT_LIST.get(0))));

    public DeprecatedProduct getDeprecatedProduct(String sku, String _package) {
        return DEPRECATED_PRODUCT_LIST.stream()
                .filter(deprecatedProduct -> deprecatedProduct.sku().equals(sku) && deprecatedProduct._package().equals(
                        _package))
                .findAny()
                .orElse(null);
    }

    public Inventory getInventory(String id) {
        return INVENTORY_LIST.stream()
                .filter(inventory -> inventory.id().equals(id))
                .findAny()
                .orElse(null);
    }

    public Product getProduct(String id) {
        return PRODUCT_LIST.stream()
                .filter(product -> product.id().equals(id))
                .findAny()
                .orElse(null);
    }

    public Product getProduct(String sku, String _package) {
        return PRODUCT_LIST.stream()
                .filter(product -> product.sku().equals(sku) && product._package().equals(_package))
                .findAny()
                .orElse(null);
    }

    public Product getProduct(String sku, ProductVariation variation) {
        return PRODUCT_LIST.stream()
                .filter(product -> product.sku().equals(sku) && product.variation().id().equals(variation.id()))
                .findAny()
                .orElse(null);
    }

    public ProductResearch getProductResearch(CaseStudy study) {
        return PRODUCT_RESEARCH_LIST.stream()
                .filter(productResearch -> productResearch.study().caseNumber().equals(study.caseNumber()))
                .findAny()
                .orElse(null);
    }

    public User getUser(String email) {
        return USER_LIST.stream()
                .filter(user -> user.email().equals(email))
                .findAny()
                .orElse(null);
    }

    public User getUser(String email, Integer totalProductsCreated, Integer yearsOfEmployment) {
        return USER_LIST.stream()
                .filter(user -> user.email().equals(email) && user.yearsOfEmployment().equals(
                        yearsOfEmployment) && user.totalProductsCreated().equals(totalProductsCreated))
                .findAny()
                .orElse(null);
    }
}
