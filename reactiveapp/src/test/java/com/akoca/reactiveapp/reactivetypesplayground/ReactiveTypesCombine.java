package com.akoca.reactiveapp.reactivetypesplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.scheduler.VirtualTimeScheduler;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReactiveTypesCombine {
    List<String> names = Arrays.asList("name 1", "name 2", "name 3", "name 4");

    @Test
    public void fluxFlatMap() {

        VirtualTimeScheduler.getOrSet();

        Flux<String> namesFlux = Flux.fromIterable(names).delayElements(Duration.ofSeconds(1));
        Flux<String> names2Flux = Flux.just("name 5", "name 6", "name 7").delayElements(Duration.ofMillis(800));

        Flux<String> mergedFlux = Flux.merge(namesFlux, names2Flux).log();
        Flux<String> concatFlux = Flux.concat(namesFlux, names2Flux).log();
        Flux<String> zippedFlux = Flux.zip(namesFlux, names2Flux, (a,b) -> a + b).log();

        /*StepVerifier.create(mergedFlux)
                //.expectSubscription()
                .expectNextCount(7)
                .verifyComplete();

        StepVerifier.create(concatFlux)
                //.expectSubscription()
                .expectNextCount(7)
                .verifyComplete();

        StepVerifier.create(zippedFlux)
                //.expectSubscription()
                .expectNextCount(3)
                .verifyComplete();

    }*/

        StepVerifier.create(mergedFlux)
                .expectSubscription()
                .thenAwait(Duration.ofSeconds(7))
                .expectNextCount(7)
                .verifyComplete();

        StepVerifier.create(concatFlux)
                .expectSubscription()
                .thenAwait(Duration.ofSeconds(7))
                .expectNextCount(7)
                .verifyComplete();

        StepVerifier.create(zippedFlux)
                .expectSubscription()
                .thenAwait(Duration.ofSeconds(7))
                .expectNextCount(3)
                .verifyComplete();

    }
}
