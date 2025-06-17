package com.agroia.api.service;

import com.agroia.api.model.Field;
import com.agroia.api.repository.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FieldService {
    private final FieldRepository fieldRepository;

    public List<Field> getAllFields() {
        return fieldRepository.findAll();
    }

    public Field getFieldById(String id) {
        return fieldRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Field not found with id: " + id));
    }

    public Field createField(Field field) {
        return fieldRepository.save(field);
    }

    public Field updateField(String id, Field field) {
        Field existingField = getFieldById(id);
        field.setId(id);
        return fieldRepository.save(field);
    }

    public void deleteField(String id) {
        Field field = getFieldById(id);
        fieldRepository.delete(field);
    }
}
