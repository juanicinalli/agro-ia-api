package com.agroia.api.repository;

import com.agroia.api.model.GrainTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrainTransactionRepository extends JpaRepository<GrainTransaction, Long> {
    List<GrainTransaction> findByGrainKey(String grainKey);
}
