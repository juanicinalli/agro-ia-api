package com.agroia.api.repository;

import com.agroia.api.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends JpaRepository<Field, String> {
    Field findById(String id);
}
