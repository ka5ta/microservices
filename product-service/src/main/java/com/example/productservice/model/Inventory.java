package com.example.productservice.model;

import java.util.UUID;

public record Inventory(
        UUID id,
         int availability) {
}
