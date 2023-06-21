package com.grad.fruit.controller;

import com.grad.fruit.domain.Fruit;
import com.grad.fruit.service.FruitService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import lombok.RequiredArgsConstructor;

@Controller("/fruit")
@RequiredArgsConstructor
@Secured(SecurityRule.IS_AUTHENTICATED)
public class FruitController {

    private final FruitService fruitService;

    @Get("seccheck")
    String index() {
        return "sherlock";
    }

    @Get(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Iterable<Fruit> findAll() {
        return fruitService.findAll();
    }

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Fruit save(@Body Fruit fruit) {
        return fruitService.save(fruit);
    }

    @Get("/{id}")
    public Fruit findById(@PathVariable String id) {
        return fruitService.findById(id);
    }

    @Delete("/{id}")
    public void deleteById(@PathVariable String id) {
        fruitService.deleteById(id);
    }

    @Get(value = "/{name}/name", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Fruit findFruitByName(@PathVariable String name) {
        return fruitService.findFruitByName(name);
    }


}
