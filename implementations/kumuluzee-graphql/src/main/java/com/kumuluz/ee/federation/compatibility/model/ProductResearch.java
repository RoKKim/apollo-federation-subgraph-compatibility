package com.kumuluz.ee.federation.compatibility.model;

import io.smallrye.graphql.api.federation.FieldSet;
import io.smallrye.graphql.api.federation.Key;
import org.eclipse.microprofile.graphql.NonNull;

@Key(fields = @FieldSet("study { caseNumber }"))
public record ProductResearch(
        @NonNull
        CaseStudy study,
        String outcome
) {
}
