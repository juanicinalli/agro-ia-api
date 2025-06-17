package com.agroia.api.controller;

import com.agroia.api.model.Field;
import com.agroia.api.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fields")
public class FieldController {
    @Autowired
    private FieldService fieldService;

    @GetMapping
    public ResponseEntity<List<Field>> getAllFields() {
        return ResponseEntity.ok(fieldService.getAllFields());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Field> getFieldById(@PathVariable String id) {
        return ResponseEntity.ok(fieldService.getFieldById(id));
    }

    @PostMapping
    public ResponseEntity<Field> createField(@RequestBody Field field) {
        return ResponseEntity.ok(fieldService.createField(field));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Field> updateField(@PathVariable String id, @RequestBody Field field) {
        return ResponseEntity.ok(fieldService.updateField(id, field));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteField(@PathVariable String id) {
        fieldService.deleteField(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/generate-plan")
    public ResponseEntity<String> generatePlan(@PathVariable String id) {
        // Aquí iría la lógica para generar el plan con Gemini
        return ResponseEntity.ok("Plan generado para el lote " + id);
    }
}
