package com.example.springbootauthorizationcode.adaptors.api.services;

import com.example.springbootauthorizationcode.adaptors.api.model.requests.ProductRequest;
import com.example.springbootauthorizationcode.adaptors.api.model.responses.ProductResponse;
import com.example.springbootauthorizationcode.model.Product;
import com.example.springbootauthorizationcode.repository.ProductRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


public class ProductHttpApiFacade {

    private final ProductRepository productRepository;

    public ProductHttpApiFacade(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> findAll() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(ProductResponse::from)
                .toList();
    }

    public ProductResponse save(ProductRequest productRequest) {
        var product = Product.builder()
                .name(productRequest.name())
                .color(productRequest.color())
                .ean(productRequest.ean())
                .countryOfOrigin(productRequest.countryOfOrigin())
                .price(productRequest.price())
                .availableQuantity(productRequest.availableQuantity())
                .build();
        Product saved = productRepository.save(product);

        return ProductResponse.from(saved);
    }

    public void deleteById(UUID productId) {
        productRepository.deleteById(productId);
    }
}