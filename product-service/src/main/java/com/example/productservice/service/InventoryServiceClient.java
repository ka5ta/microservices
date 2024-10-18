package com.example.productservice.service;

import com.example.productservice.model.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "inventory-service")
public interface InventoryServiceClient {


    @GetMapping("inventory")
    List<Inventory> getAvailabilityByIds(@RequestParam String... id);
}

