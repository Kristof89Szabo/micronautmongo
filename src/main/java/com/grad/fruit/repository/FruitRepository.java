package com.grad.fruit.repository;

import com.grad.fruit.domain.Fruit;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@MongoRepository(databaseName = "fruit")
public interface FruitRepository extends CrudRepository<Fruit, String> {

//    @MongoFindQuery("{ 'name': :name }")
//    Optional<Fruit> findFruitByName(String name);

    Optional<Fruit> findByName(String name);

//    Optional<Fruit> findByNameLike(String name);
//    Optional<Fruit> findByNameIlike(String name); //Ilike -> Not case sensitive
//    List<String> findNameByNameIlike(String name); // List of fruit name like given

//    @Query(value = "SELECT * FROM fruit as f where f.name like :name", nativeQuery = true)
//    List<Fruit> findNativeFruits(String name); // Query not working with mongo DB, just wanted to show we can write native query to SQL.

}
