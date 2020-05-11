package com.akoca.reactiveapp.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebFluxTest
public class FluxAndMonoControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    public void fluxApproach1() {
        Flux<Integer> result = webTestClient
                .mutate()
                    .responseTimeout(Duration.ofSeconds(20))
                    .build()
                .get()
                .uri("/flux")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .returnResult(Integer.class)
                .getResponseBody();

        StepVerifier.create(result)
                .expectSubscription()
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .expectNext(5)
                .verifyComplete();
    }

    @Test
    public void fluxApproach2() {
        webTestClient
                .mutate()
                .responseTimeout(Duration.ofSeconds(20))
                .build()
                .get()
                .uri("/flux")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader()
                    .contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Integer.class)
                .hasSize(5);

    }

    @Test
    public void fluxApproach3() {
        EntityExchangeResult<List<Integer>> entityExchangeResult = webTestClient
                .mutate()
                .responseTimeout(Duration.ofSeconds(20))
                .build()
                .get()
                .uri("/flux")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Integer.class)
                .returnResult();

        assertEquals((Arrays.asList(1, 2, 3, 4, 5)), entityExchangeResult.getResponseBody());
    }

    @Test
    public void fluxApproach4() {
        webTestClient
                .mutate()
                .responseTimeout(Duration.ofSeconds(20))
                .build()
                .get()
                .uri("/flux")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Integer.class)
                .consumeWith((entityExchangeResult) -> {
                    assertEquals((Arrays.asList(1, 2, 3, 4, 5)), entityExchangeResult.getResponseBody());
                });
    }

    @Test
    public void fluxStream() {
        Flux<Long> result = webTestClient
                .mutate()
                .responseTimeout(Duration.ofSeconds(20))
                .build()
                .get()
                .uri("/flux-stream")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .exchange()
                .expectStatus().isOk()
                .returnResult(Long.class)
                .getResponseBody();

        StepVerifier.create(result)
                .expectSubscription()
                .expectNext(0L)
                .expectNext(1L)
                .expectNext(2L)
                .expectNext(3L)
                .expectNext(4L)
                .expectNext(5L)
                .thenCancel()
                .verify();
    }

    @Test
    public void testMono() {
        Flux<Long> result = webTestClient
                .mutate()
                .responseTimeout(Duration.ofSeconds(20))
                .build()
                .get()
                .uri("/flux-stream")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .exchange()
                .expectStatus().isOk()
                .returnResult(Long.class)
                .getResponseBody();
    }
}