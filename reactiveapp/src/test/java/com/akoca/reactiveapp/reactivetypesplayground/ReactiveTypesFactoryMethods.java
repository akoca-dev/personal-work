package com.akoca.reactiveapp.reactivetypesplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReactiveTypesFactoryMethods {
    List<String> names = Arrays.asList("name1", "name2", "name3", "name4");

    @Test
    public void fluxUsingIterable() {
        Flux<String> namesFlux = Flux.fromIterable(names).log();
        Flux<String> namesFluxFrom = Flux.from(namesFlux);
        Flux<String> namesFluxFromStream = Flux.fromStream(names.stream());

        StepVerifier.create(namesFlux)
                .expectNextCount(4)
                .verifyComplete();

        StepVerifier.create(namesFluxFromStream)
                .expectNextCount(4)
                .verifyComplete();

        StepVerifier.create(namesFluxFrom)
                .expectNextCount(4)
                .verifyComplete();
    }

    @Test
    public void monoUsingJustOrEmpty() {
        Mono<String> stringMono = Mono.justOrEmpty(Optional.empty());

        StepVerifier.create(stringMono.log()).verifyComplete();
    }
}
