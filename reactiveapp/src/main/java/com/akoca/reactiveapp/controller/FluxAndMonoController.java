package com.akoca.reactiveapp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class FluxAndMonoController {

    @GetMapping(path = "/flux")
    public Flux<Integer> fluxDemo() {
        return Flux
                .range(1, 5)
                .delayElements(Duration.ofSeconds(2))
                .log();
    }

    @GetMapping(path = "/flux-stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Long> fluxStreamDemo() {
        return Flux
                .interval(Duration.ofSeconds(1))
                .log();
    }

    @GetMapping(path = "/mono")
    public Mono<Integer> fluxDemoMono() {
        return Mono.just(1)
                .log();
    }
}
