package com.example.springbootauthorizationcode.repository;


import com.example.springbootauthorizationcode.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    List<Product> findAll();

    Optional<Product> findById(UUID productId);

    Product save(Product product);

    void deleteById(UUID productId);
}