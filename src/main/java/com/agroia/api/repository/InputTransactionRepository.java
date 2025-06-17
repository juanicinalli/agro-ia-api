package com.agroia.api.repository;

import com.agroia.api.model.InputTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InputTransactionRepository extends JpaRepository<InputTransaction, Long> {
    List<InputTransaction> findByInputId(Long inputId);
}
