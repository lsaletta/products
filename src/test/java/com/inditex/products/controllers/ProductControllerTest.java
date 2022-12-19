package com.inditex.products.controllers;


import com.inditex.products.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    public static final String PRODUTCS_PATH = "/inditex/products";

    @LocalServerPort
    private int port;

    private String urlBase;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void init() throws MalformedURLException {
        urlBase = new URL("http://localhost:" + port).toString();
    }

    @Test
    public void whenGetAvailableProductsReturnOk() {

        ResponseEntity<List<Product>> response = restTemplate.exchange(urlBase + PRODUTCS_PATH,
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(response.getBody().get(0).getId(), 5);
        assertEquals(response.getBody().get(1).getId(), 1);
        assertEquals(response.getBody().get(2).getId(), 3);
    }

}
