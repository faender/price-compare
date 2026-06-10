package com.example.pricecompare;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;




@ExtendWith(MockitoExtension.class)
class ProductServiceTests {

    @Mock
    ProductRepository repository;

    @InjectMocks
    ProductService service;

    @Test
    void getAllProducts_returnsAllProducts() {
        // Arrange
        List<Product> fakeProducts = List.of(
            new Product("iPhone", "Handy", 999.99),
            new Product("MacBook", "Laptop", 2499.99)
        );
        when(repository.findAll()).thenReturn(fakeProducts);

        // Act
        List<Product> result = service.getAllProducts();

        // Assert
        assertEquals(2, result.size());
        assertEquals("iPhone", result.get(0).getName());
    }

    @Test
    void createProduct_withNegativePrice_throwsException() {
        // Arrange
        Product invalidProduct = new Product("iPhone", "Handy", -100);

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.createProduct(invalidProduct);
        });

        // Assert
        assertEquals("Preis kann nicht negativ sein", exception.getMessage());
    }

    @Test
    void getProductsByCategory_returnsCorrectAmount() {
        // Arrange
        List<Product> fakeHandys = List.of(
                new Product("iPhone", "Handy", 999.99),
                new Product("Samsung", "Handy", 849.99)
        );
        when(repository.findByCategory("Handy")).thenReturn(fakeHandys);

        // Act
        List<Product> result = service.getProductsByCategory("Handy");

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    void getProductsByCategory_returnsOnlyMatchingCategory() {
        // Arrange
        List<Product> fakeHandys = List.of(
                new Product("iPhone", "Handy", 999.99),
                new Product("Samsung", "Handy", 849.99)
        );
        when(repository.findByCategory("Handy")).thenReturn(fakeHandys);

        // Act
        List<Product> result = service.getProductsByCategory("Handy");

        // Assert
        assertTrue(result.stream().allMatch(p -> p.getCategory().equals("Handy")));
    }

}