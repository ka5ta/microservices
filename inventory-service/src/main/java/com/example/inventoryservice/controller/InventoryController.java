package com.example.inventoryservice.controller;

import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryRepository inventoryRepository;

    @GetMapping("/inventory")
    public List<Inventory> getById(@RequestParam String... id) {
        List<UUID> uuids = Arrays.stream(id)
                .map(UUID::fromString)
                .toList();
        // todo uuid might be incorrect

        List<Inventory> allById = (List<Inventory>) inventoryRepository.findAllById(uuids);
        return allById;
    }
}
