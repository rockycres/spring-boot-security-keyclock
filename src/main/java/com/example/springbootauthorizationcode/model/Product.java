package com.example.springbootauthorizationcode.model;


import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Product {

    private UUID id;
    private String name;
    private String color;
    private String ean;
    private String countryOfOrigin;
    private String price;
    private int availableQuantity;
}