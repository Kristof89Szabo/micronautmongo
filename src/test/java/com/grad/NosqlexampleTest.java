package com.grad;

import com.grad.fruit.domain.Color;
import com.grad.fruit.domain.Fruit;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@MicronautTest
class FruitValidationControllerTest {

    @Test
    void fruitIsValid(@Client("/fruit") HttpClient httpClient) {
        //Given
        Color black = new Color("black");
        Fruit fruit1 = new Fruit("1", "apple", black);

        String authHeader = getBasicAuthHeader();
        //When
        BlockingHttpClient client = httpClient.toBlocking();
        HttpResponse<?> response = assertDoesNotThrow(() -> client.exchange(
                HttpRequest.POST("", fruit1)
                        .header(HttpHeaders.AUTHORIZATION, authHeader)
        ));
        //Then
        assertEquals(HttpStatus.CREATED, response.getStatus());

    }

    @Test
    void fruitNotValid(@Client("/fruit") HttpClient httpClient) {
        //Given
        Fruit fruit2 = new Fruit("1", "apple", new Color(null));
        BlockingHttpClient client = httpClient.toBlocking();
        String authHeader = getBasicAuthHeader();

        //When
        HttpClientResponseException exception = assertThrows(HttpClientResponseException.class, () ->
                client.exchange(HttpRequest.POST("", fruit2).header(HttpHeaders.AUTHORIZATION, authHeader)));
        //Then
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());

    }


    private String getBasicAuthHeader() {
        String credentials = "sherlock" + ":" + "password";
        byte[] credentialsBytes = credentials.getBytes(StandardCharsets.UTF_8);
        String base64Credentials = Base64.getEncoder().encodeToString(credentialsBytes);
        return "Basic " + base64Credentials;
    }
}

