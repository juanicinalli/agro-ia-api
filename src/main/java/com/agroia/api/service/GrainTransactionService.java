package com.agroia.api.service;

import com.agroia.api.model.GrainTransaction;
import java.util.List;

public interface GrainTransactionService {
    GrainTransaction createGrainTransaction(GrainTransaction transaction);
    List<GrainTransaction> getTransactionsByGrainKey(String grainKey);
    GrainTransaction getTransactionById(Long id);
    GrainTransaction updateTransaction(Long id, GrainTransaction transaction);
    void deleteTransaction(Long id);
}
