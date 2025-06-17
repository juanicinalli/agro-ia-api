package com.agroia.api.controller;

import com.agroia.api.model.EconomicTransaction;
import com.agroia.api.service.EconomicTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/balance")
public class BalanceController {
    @Autowired
    private EconomicTransactionService transactionService;

    @GetMapping("/transactions")
    public ResponseEntity<List<EconomicTransaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<EconomicTransaction> getTransactionById(@PathVariable String id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @PostMapping("/transactions")
    public ResponseEntity<EconomicTransaction> createTransaction(@RequestBody EconomicTransaction transaction) {
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }

    @PutMapping("/transactions/{id}")
    public ResponseEntity<EconomicTransaction> updateTransaction(
            @PathVariable String id,
            @RequestBody EconomicTransaction transaction) {
        return ResponseEntity.ok(transactionService.updateTransaction(id, transaction));
    }

    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable String id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
