package com.example.productservice.service;

import com.example.productservice.dto.ProductDTO;
import com.example.productservice.mapper.ProductMapper;
import com.example.productservice.model.Inventory;
import com.example.productservice.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CatalogServiceClient catalogServiceClient;
    private final InventoryServiceClient inventoryServiceClient;
    private final ProductMapper productMapper;

    public ProductDTO getAvailableProduct(String id){
        List<Inventory> inventory = inventoryServiceClient.getAvailabilityByIds(id);

        if(inventory.size() != 1){
            return null;
        }

        int availability = inventory.get(0).availability();

        if(availability == 0){
            return null;
        }

        Product product = catalogServiceClient.getProductById(id);
        ProductDTO dto = productMapper.toDto(product);
        dto.setAvailability(availability);

        return dto;
    }


    public List<ProductDTO> getAvailableProducts(String sku) {
        List<Product> products = catalogServiceClient.getProductsWithSku(sku);

        if(products.isEmpty()){
            return Collections.emptyList();
        }

        String productIds = products.stream()
                .map(product -> product.getId().toString())
                .collect(Collectors.joining(","));

        List<Inventory> inventories = inventoryServiceClient.getAvailabilityByIds(productIds);

        List<ProductDTO> productsDtos = new ArrayList<>();

        for(Product product : products) {
            UUID productId = product.getId();

            Inventory matchedInventory = inventories.stream()
                    .filter(inventory -> inventory.id().equals(productId))
                    .findFirst()
                    .orElse(null);

            if(null == matchedInventory || matchedInventory.availability() == 0) {
                continue;
            }

            ProductDTO productDTO = productMapper.toDto(product);
            productDTO.setAvailability(matchedInventory.availability());

            productsDtos.add(productDTO);
        }

        return productsDtos;
    }
}
