package com.example.inventoryservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter @Setter
@Table(name="inventory")
public class Inventory {

    @Id
    @Column(name = "uniq_id")
    private UUID id;
    private int availability;

}
