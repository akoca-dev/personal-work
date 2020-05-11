package com.akoca.reactiveapp.reactivetypesplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static reactor.core.scheduler.Schedulers.parallel;

public class ReactiveTypesFlatMapping {
    List<String> names = Arrays.asList("name 1", "name 2", "name 3", "name 4");

    @Test
    public void fluxFlatMap() {
        Flux<String> namesFlux = Flux.fromIterable(names);

        Flux<String> splittedNames = namesFlux.flatMap(s -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Flux.fromIterable(Arrays.asList(s.split(" ")));
        }).log();

        StepVerifier.create(splittedNames)
                .expectNextCount(8)
                .verifyComplete();
    }

    @Test
    public void fluxFlatMapParallel() {
        Flux<String> namesFlux = Flux.fromIterable(names);

        Flux<String> splitNames = namesFlux
                .window(2)
                .flatMapSequential(s -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Flux<String[]> stringArrayFlux = s.map(a -> a.split(" ")).subscribeOn(parallel());

                    return stringArrayFlux
                            .flatMap(Flux::fromArray);
        }).log();

        StepVerifier.create(splitNames)
                .expectNextCount(8)
                .verifyComplete();
    }
}
