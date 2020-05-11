package com.akoca.reactiveapp.repository;

import com.akoca.reactiveapp.document.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class ItemReactiveRepositoryTest {
    @Autowired
    private ItemReactiveRepository itemReactiveRepository;

    @BeforeAll
    public void createData() {
        itemReactiveRepository
                .deleteAll()
                .thenMany(Flux.fromIterable()));

        StepVerifier.create(itemFlux)
                .expectSubscription()
                .expectNextCount(0)
                .verifyComplete();
    }

    @Test
    public void itemRepoTest() {
        Flux<Item> itemFlux = itemReactiveRepository.findAll();

        StepVerifier.create(itemFlux)
                .expectSubscription()
                .expectNextCount(0)
                .verifyComplete();
    }
}