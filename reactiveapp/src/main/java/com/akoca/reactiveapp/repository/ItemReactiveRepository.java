package com.akoca.reactiveapp.repository;

import com.akoca.reactiveapp.document.Item;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ItemReactiveRepository extends ReactiveMongoRepository<Item, String> {
}