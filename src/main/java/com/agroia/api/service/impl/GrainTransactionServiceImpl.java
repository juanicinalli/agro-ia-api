package com.agroia.api.service.impl;

import com.agroia.api.model.GrainTransaction;
import com.agroia.api.repository.GrainTransactionRepository;
import com.agroia.api.service.GrainTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GrainTransactionServiceImpl implements GrainTransactionService {
    @Autowired
    private GrainTransactionRepository grainTransactionRepository;

    @Override
    public GrainTransaction createGrainTransaction(GrainTransaction transaction) {
        return grainTransactionRepository.save(transaction);
    }

    @Override
    public List<GrainTransaction> getTransactionsByGrainKey(String grainKey) {
        return grainTransactionRepository.findByGrainKey(grainKey);
    }

    @Override
    public GrainTransaction getTransactionById(Long id) {
        return grainTransactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }

    @Override
    public GrainTransaction updateTransaction(Long id, GrainTransaction transaction) {
        GrainTransaction existing = getTransactionById(id);
        existing.setType(transaction.getType());
        existing.setQuantity(transaction.getQuantity());
        existing.setLocation(transaction.getLocation());
        existing.setDate(transaction.getDate());
        return grainTransactionRepository.save(existing);
    }

    @Override
    public void deleteTransaction(Long id) {
        GrainTransaction transaction = getTransactionById(id);
        grainTransactionRepository.delete(transaction);
    }
}
