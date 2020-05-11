package com.akoca.reactiveapp.reactivetypesplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class ReactiveTypesPlayground  {

    @Test
    public void fluxTest() {
        Flux
                .just("data1", "data2", "data3,", "data4")
/*                .concatWith(Flux.error(() -> {
                    return new RuntimeException("Demo Exception");
                }))*/
                .log()
                .subscribe(System.out::println, (e) -> e.printStackTrace(), () -> System.err.println("Completed"));
    }

    @Test
    public void fluxTestSteps() {
        Flux<String> stringFlux = Flux
                .just("data1", "data2", "data3", "data4")
                .log();

        StepVerifier.create(stringFlux)
                .expectNext("data1")
                .expectNext("data2")
                .expectNext("data3")
                .expectNext("data4")
                .verifyComplete();
    }

    @Test
    public void fluxTestStepsWithError() {
        Flux<String> stringFlux = Flux
                .just("data1", "data2", "data3", "data4")
                .concatWith(Flux.error(() -> new RuntimeException("Demo Exception")))
                .log();

        StepVerifier.create(stringFlux)
                .expectNext("data1")
                .expectNext("data2")
                .expectNext("data3")
                .expectNext("data4")
                .expectErrorMessage("Demo Exception")
                .verify();
    }

    @Test
    public void fluxTestStepsCount() {
        Flux<String> stringFlux = Flux
                .just("data1", "data2", "data3", "data4")
                .concatWith(Flux.error(() -> new RuntimeException("Demo Exception")))
                .log();

        StepVerifier.create(stringFlux)
                .expectNextCount(4)
                .expectErrorMessage("Demo Exception")
                .verify();
    }

    @Test
    public void monoTest() {
        Mono<String> stringMono = Mono.just("data1").log();

        StepVerifier.create(stringMono)
                .expectNext("data1")
                .verifyComplete();
    }

    @Test
    public void monoTestError() {

        StepVerifier.create(Mono.error(RuntimeException::new).log())
                .expectError(RuntimeException.class)
                .verify();
    }
}
