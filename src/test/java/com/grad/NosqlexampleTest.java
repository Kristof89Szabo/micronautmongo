package com.grad;

import com.grad.fruit.domain.Fruit;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@MicronautTest
class FruitValidationControllerTest {

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    void fruitIsValidated() {
        HttpClientResponseException exception = assertThrows(
                HttpClientResponseException.class,
                () -> httpClient.toBlocking().exchange(HttpRequest.POST("/fruit", new Fruit(null)))
        );

        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
    }
}

