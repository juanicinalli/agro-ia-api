package com.agroia.api.service.impl;

import com.agroia.api.model.InputTransaction;
import com.agroia.api.repository.InputTransactionRepository;
import com.agroia.api.service.InputTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InputTransactionServiceImpl implements InputTransactionService {
    @Autowired
    private InputTransactionRepository inputTransactionRepository;

    @Override
    public InputTransaction createInputTransaction(InputTransaction transaction) {
        return inputTransactionRepository.save(transaction);
    }

    @Override
    public List<InputTransaction> getTransactionsByInputId(Long inputId) {
        return inputTransactionRepository.findByInputId(inputId);
    }

    @Override
    public InputTransaction getTransactionById(Long id) {
        return inputTransactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }

    @Override
    public InputTransaction updateTransaction(Long id, InputTransaction transaction) {
        InputTransaction existing = getTransactionById(id);
        existing.setType(transaction.getType());
        existing.setQuantity(transaction.getQuantity());
        existing.setReason(transaction.getReason());
        existing.setDate(transaction.getDate());
        return inputTransactionRepository.save(existing);
    }

    @Override
    public void deleteTransaction(Long id) {
        InputTransaction transaction = getTransactionById(id);
        inputTransactionRepository.delete(transaction);
    }
}
