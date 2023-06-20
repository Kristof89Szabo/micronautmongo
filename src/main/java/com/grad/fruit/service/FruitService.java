package com.grad.fruit.service;

import com.grad.fruit.domain.Fruit;
import com.grad.fruit.repository.FruitRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class FruitService {

    private final FruitRepository fruitRepository;

    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public Iterable<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    public Fruit findById(String id) {
        return fruitRepository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        fruitRepository.deleteById(id);
    }

    public Fruit findFruitByName(String name) {
        return fruitRepository.findFruitByName(name).orElseThrow( () -> new RuntimeException("Could not find fruit under: " + name));
    }
}
