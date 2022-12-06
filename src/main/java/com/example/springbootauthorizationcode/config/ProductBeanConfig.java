package com.example.springbootauthorizationcode.config;

import com.example.springbootauthorizationcode.adaptors.InMemoryProductRepository;
import com.example.springbootauthorizationcode.adaptors.api.services.ProductHttpApiFacade;
import com.example.springbootauthorizationcode.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductBeanConfig {

    @Bean
    public ProductRepository productRepository() {
        return new InMemoryProductRepository();
    }

    @Bean
    public ProductHttpApiFacade productHttpApiFacade(ProductRepository productRepository) {
        return new ProductHttpApiFacade(productRepository);
    }
}