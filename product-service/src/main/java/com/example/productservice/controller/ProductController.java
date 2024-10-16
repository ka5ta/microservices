package com.example.productservice.controller;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("catalog")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ProductDTO getAvailableProduct(@RequestParam String id) {
        return productService.getAvailableProduct(id);
    }

    @GetMapping
    public List<ProductDTO> getAvailableProducts(@RequestParam String sku) {
        return productService.getAvailableProducts(sku);
    }
}
