package com.grad.fruit.domain;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@MappedEntity
@AllArgsConstructor
public class Fruit {

    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private String id;

    @NotNull
    @NotEmpty
    @Size(min = 3)
    private String name;

    @NotNull
    private Integer price;

    @Valid
    private Color color;

}
