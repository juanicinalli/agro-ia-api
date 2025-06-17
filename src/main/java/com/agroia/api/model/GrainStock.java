package com.agroia.api.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class GrainStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "grain_stock_items")
    @MapKeyColumn(name = "grain_name")
    @Column(name = "item")
    private Map<String, GrainItem> grains;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Embeddable
    public static class GrainItem {
        private String name;
        private Double amount;
        private String unit;
        private String quality;
        private String color;
    }
}
