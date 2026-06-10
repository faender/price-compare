package com.example.pricecompare;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Product> getProductsByCategory(String category) {
        return repository.findByCategory(category);
    }

    public Product createProduct(Product product) {
        if (product.getPrice() < 0) {
            throw new IllegalArgumentException("Preis kann nicht negativ sein");
        }
        return repository.save(product);
    }

    public void deleteProductById(String id) {
        repository.deleteById(id);
    }
}

