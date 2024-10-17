package com.example.productservice.controller;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.exception.IdNotValidException;
import com.example.productservice.service.ProductService;
import feign.RetryableException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("catalog")
@Slf4j
public class ProductController {

    private final ProductService productService;

    @CircuitBreaker(name = "productById", fallbackMethod = "fallback")
    @GetMapping("/products")
    public ResponseEntity<ProductDTO> getAvailableProduct(@RequestParam String id) {
        ProductDTO availableProduct = productService.getAvailableProduct(id);

        if (id.contains("1")) {
            throw new IdNotValidException();
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(availableProduct);
    }

    @CircuitBreaker(name = "productsBySku", fallbackMethod = "fallback")
    @GetMapping
    public ResponseEntity<String> getAvailableProducts(@RequestParam String sku) {
        List<ProductDTO> availableProducts = productService.getAvailableProducts(sku);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(availableProducts.toString());
    }

    private ResponseEntity<String> fallback (String param, RetryableException exception) {
        log.error("Service call have thrown " + exception.getClass().getCanonicalName());

        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("There was a problem retrieving data for " + param);
    }

    private ResponseEntity<String> fallback (String param, IdNotValidException exception) {
        log.error("Service call have thrown " + exception.getClass().getCanonicalName());
        String message = exception.getMessage();

        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(String.format("There was a problem retrieving data for %s; Cause: %s", param, message));
    }

    private ResponseEntity<String> fallback (String param, CallNotPermittedException exception) {
        log.error(exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Server not responding. Try again later.");
    }
}
