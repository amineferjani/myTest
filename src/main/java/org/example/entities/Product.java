package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@Entity @AllArgsConstructor @NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private int qte;
    private double prix;
}
