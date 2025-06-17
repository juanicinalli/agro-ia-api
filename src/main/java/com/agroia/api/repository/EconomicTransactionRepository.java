package com.agroia.api.repository;

import com.agroia.api.model.EconomicTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EconomicTransactionRepository extends JpaRepository<EconomicTransaction, String> {
    EconomicTransaction findById(String id);
}
