package com.akoca.reactiveapp.reactivetypesplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ReactiveTypesErrorHandling {
    @Test
    public void testInfinite() throws InterruptedException {

        Flux<Long> longFlux = Flux.interval(Duration.ofMillis(200)).log();

        longFlux.subscribe(System.err :: println);
        longFlux.subscribe(e -> System.err.println("e " + e));

        StepVerifier.create(longFlux)
                .expectSubscription()
                //.expectNextCount(Long.MAX_VALUE)
                .verifyComplete();
    }

    @Test
    public void testErrorResume() throws InterruptedException {

        Flux<Long> longFlux = Flux.interval(Duration.ofMillis(200)).log().take(5);

        StepVerifier.Step<Long> step1 = StepVerifier.create(longFlux)
                .expectSubscription()
                .expectNext(0L)
                .expectNext(1L)
                .expectNext(2L)
                .expectNext(3L)
                .expectNext(4L);

        StepVerifier.Step<Long> step2 = StepVerifier.create(longFlux)
                .expectSubscription()
                .expectNext(0L)
                .expectNext(1L)
                .expectNext(2L)
                .expectNext(3L)
                .expectNext(4L);

        step2.verifyComplete();
        step1.verifyComplete();

    }
}
