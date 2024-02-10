package com.kumuluz.ee.federation.compatibility.model;

import org.eclipse.microprofile.graphql.Id;
import org.eclipse.microprofile.graphql.NonNull;

public record CaseStudy(
        @Id
        @NonNull
        String caseNumber,
        String description
) {
}
