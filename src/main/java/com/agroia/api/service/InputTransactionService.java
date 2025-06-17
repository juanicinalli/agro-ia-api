package com.agroia.api.service;

import com.agroia.api.model.InputTransaction;
import java.util.List;

public interface InputTransactionService {
    InputTransaction createInputTransaction(InputTransaction transaction);
    List<InputTransaction> getTransactionsByInputId(Long inputId);
    InputTransaction getTransactionById(Long id);
    InputTransaction updateTransaction(Long id, InputTransaction transaction);
    void deleteTransaction(Long id);
}
