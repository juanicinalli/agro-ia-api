package com.agroia.api.repository;

import com.agroia.api.model.GrainStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrainStockRepository extends JpaRepository<GrainStock, Long> {
    GrainStock findByGrainsKey(String grainKey);
}
