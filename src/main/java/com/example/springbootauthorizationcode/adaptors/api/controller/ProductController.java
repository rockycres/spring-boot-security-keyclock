package com.example.springbootauthorizationcode.adaptors.api.controller;

import com.example.springbootauthorizationcode.adaptors.MustBeChiefOperatingOfficer;
import com.example.springbootauthorizationcode.adaptors.api.model.requests.ProductRequest;
import com.example.springbootauthorizationcode.adaptors.api.model.responses.ProductResponse;
import com.example.springbootauthorizationcode.adaptors.api.services.ProductHttpApiFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Products")
public class ProductController {


    private final ProductHttpApiFacade apiFacade;

    public ProductController(ProductHttpApiFacade apiFacade) {
        this.apiFacade = apiFacade;
    }

    @GetMapping
    @Operation(summary = "Return all products")
    public ResponseEntity<List<ProductResponse>> findAll() {
        return new ResponseEntity<>(apiFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Save a new product")
    public ResponseEntity<ProductResponse> save(@RequestBody ProductRequest newProduct) {
        return new ResponseEntity<>(apiFacade.save(newProduct), HttpStatus.OK);
    }

    @DeleteMapping("{productId}")
    @MustBeChiefOperatingOfficer
    @Operation(summary = "Remove a product by id. Available only for the chief-operating-officer role. " +
            "By default only christina has this role.")
    public ResponseEntity<Void> delete(@PathVariable UUID productId) {
        apiFacade.deleteById(productId);

        return ResponseEntity.noContent().build();
    }
}