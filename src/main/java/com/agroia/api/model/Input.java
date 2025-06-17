package com.agroia.api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "inputs")
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String type; // Fertilizante, Herbicida, etc.
    private String unit; // kg, litros
    private double stock;
}
