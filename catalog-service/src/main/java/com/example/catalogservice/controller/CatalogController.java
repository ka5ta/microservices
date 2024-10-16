package com.example.catalogservice.controller;

import com.example.catalogservice.model.Product;
import com.example.catalogservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CatalogController {

    private final ProductRepository productRepository;

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable String id){
        UUID uuid = UUID.fromString(id);
        Optional<Product> byId = productRepository.findById(uuid);
        return byId.orElse(null);
    }

    @GetMapping("/products")
    public List<Product> getProductsWithSku(@RequestParam String sku){
        return productRepository.findBySku(sku);
    }
}