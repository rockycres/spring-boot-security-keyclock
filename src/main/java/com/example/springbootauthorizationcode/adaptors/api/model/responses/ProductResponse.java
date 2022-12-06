package com.example.springbootauthorizationcode.adaptors.api.model.responses;


import com.example.springbootauthorizationcode.model.Product;

import java.util.UUID;

public record ProductResponse(
        UUID id,
        String name,
        String color,
        String ean,
        String countryOfOrigin,
        String price,
        int availableQuantity) {

    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getColor(),
                product.getEan(),
                product.getCountryOfOrigin(),
                product.getPrice(),
                product.getAvailableQuantity()
        );
    }
}