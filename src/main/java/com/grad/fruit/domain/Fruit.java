package com.grad.fruit.domain;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@MappedEntity
public class Fruit {

    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private String id;

    @NotNull
    @NotEmpty
    private String name;

    public Fruit(@NotNull String name) {
        this.name = name;
    }
}
