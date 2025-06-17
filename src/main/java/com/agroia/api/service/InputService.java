package com.agroia.api.service;

import com.agroia.api.model.Input;
import com.agroia.api.repository.InputRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InputService {
    private final InputRepository inputRepository;

    public List<Input> getAllInputs() {
        return inputRepository.findAll();
    }

    public Input getInputById(String id) {
        return inputRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Input not found with id: " + id));
    }

    public Input createInput(Input input) {
        return inputRepository.save(input);
    }

    public Input updateInput(String id, Input input) {
        Input existingInput = getInputById(id);
        input.setId(id);
        return inputRepository.save(input);
    }

    public void deleteInput(String id) {
        Input input = getInputById(id);
        inputRepository.delete(input);
    }

    public Input adjustStock(String id, double quantity, String type) {
        Input input = getInputById(id);
        if (type.equalsIgnoreCase("add")) {
            input.setStock(input.getStock() + quantity);
        } else if (type.equalsIgnoreCase("remove")) {
            if (input.getStock() < quantity) {
                throw new RuntimeException("Not enough stock to remove");
            }
            input.setStock(input.getStock() - quantity);
        }
        return inputRepository.save(input);
    }
}
