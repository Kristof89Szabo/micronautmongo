package com.grad.fruit.repository;

import com.grad.fruit.domain.Fruit;
import io.micronaut.data.mongodb.annotation.MongoFindQuery;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@MongoRepository
public interface FruitRepository extends CrudRepository<Fruit, String> {

    @MongoFindQuery("{ 'name': :name }")
    Optional<Fruit> findFruitByName(String name);
}
