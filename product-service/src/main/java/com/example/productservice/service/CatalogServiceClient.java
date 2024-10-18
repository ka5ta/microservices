package com.example.productservice.service;

import com.example.productservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FeignClient(value = "catalog-service")
public interface CatalogServiceClient {

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable String id);

    @GetMapping("/products")
    List<Product> getProductsWithSku(@RequestParam String sku);
}