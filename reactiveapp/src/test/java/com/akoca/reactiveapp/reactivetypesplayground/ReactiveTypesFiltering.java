package com.akoca.reactiveapp.reactivetypesplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

public class ReactiveTypesFiltering {
    List<String> names = Arrays.asList("name1", "name2", "name3", "name4");

    @Test
    public void fluxFilter() {
        Flux<String> namesFlux = Flux.fromIterable(names).log();
        Flux<String> namesFluxFromFilter = Flux.from(namesFlux).filter(s -> s.endsWith("e3"));
        ;

        StepVerifier.create(namesFlux)
                .expectNextCount(4)
                .verifyComplete();

        StepVerifier.create(namesFluxFromFilter)
                .expectNextCount(4)
                .verifyComplete();
    }
}
