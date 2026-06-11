package com.example.pricecompare;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
class ProductControllerIntegrationTest {

    @Container
    @ServiceConnection
    static MongoDBContainer mongodb = new MongoDBContainer("mongo:7");

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProductRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void getAllProducts_returnsEmptyList() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void createProduct_savesAndReturnsProduct() throws Exception {
        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"iPhone\",\"category\":\"Handy\",\"price\":999.99}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("iPhone"))
                .andExpect(jsonPath("$.category").value("Handy"));
    }

    @Test
    void getProductsByCategory_returnsMatchingProducts() throws Exception {
        repository.save(new Product("iPhone", "Handy", 999.99));
        repository.save(new Product("MacBook", "Laptop", 2499.99));

        mockMvc.perform(get("/products/category/Handy"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("iPhone"));
    }
}