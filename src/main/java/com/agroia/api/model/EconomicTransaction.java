package com.agroia.api.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "economic_transactions")
public class EconomicTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String type; // income o expense
    private String concept;
    private double amount;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String category; // opcional
}
