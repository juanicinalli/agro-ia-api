package com.agroia.api.service;

import com.agroia.api.model.EconomicTransaction;
import com.agroia.api.repository.EconomicTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EconomicTransactionService {
    private final EconomicTransactionRepository transactionRepository;

    public List<EconomicTransaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public EconomicTransaction getTransactionById(String id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }

    public EconomicTransaction createTransaction(EconomicTransaction transaction) {
        return transactionRepository.save(transaction);
    }

    public EconomicTransaction updateTransaction(String id, EconomicTransaction transaction) {
        EconomicTransaction existing = getTransactionById(id);
        transaction.setId(id);
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(String id) {
        EconomicTransaction transaction = getTransactionById(id);
        transactionRepository.delete(transaction);
    }
}
