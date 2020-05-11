package com.akoca.reactiveapp.reactivetypesplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

public class ReactiveTypesMapping {
    List<String> names = Arrays.asList("name1", "name2", "name3", "name4");

    @Test
    public void fluxFilter() {
        Flux<String> namesFlux = Flux.fromIterable(names);
        Flux<String> namesFluxFromMap = Flux.from(namesFlux).map(String :: toUpperCase).log().repeat(1);

        StepVerifier.create(namesFluxFromMap)
                .expectNextCount(8)
                .verifyComplete();
    }
}
