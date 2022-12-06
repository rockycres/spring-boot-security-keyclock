package com.example.springbootauthorizationcode.adaptors.api.model.requests;


public record ProductRequest(
        String name,
        String color,
        String ean,
        String countryOfOrigin,
        String price,
        int availableQuantity) {
}