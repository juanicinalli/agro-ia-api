package com.agroia.api.controller;

import com.agroia.api.model.Input;
import com.agroia.api.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InputService inputService;

    @GetMapping("/inputs")
    public ResponseEntity<List<Input>> getAllInputs() {
        return ResponseEntity.ok(inputService.getAllInputs());
    }

    @GetMapping("/inputs/{id}")
    public ResponseEntity<Input> getInputById(@PathVariable String id) {
        return ResponseEntity.ok(inputService.getInputById(id));
    }

    @PostMapping("/inputs")
    public ResponseEntity<Input> createInput(@RequestBody Input input) {
        return ResponseEntity.ok(inputService.createInput(input));
    }

    @PutMapping("/inputs/{id}")
    public ResponseEntity<Input> updateInput(@PathVariable String id, @RequestBody Input input) {
        return ResponseEntity.ok(inputService.updateInput(id, input));
    }

    @DeleteMapping("/inputs/{id}")
    public ResponseEntity<Void> deleteInput(@PathVariable String id) {
        inputService.deleteInput(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/inputs/stock-adjustment")
    public ResponseEntity<Input> adjustStock(
            @RequestParam String inputId,
            @RequestParam double quantity,
            @RequestParam String type,
            @RequestParam String reason) {
        return ResponseEntity.ok(inputService.adjustStock(inputId, quantity, type));
    }
}
