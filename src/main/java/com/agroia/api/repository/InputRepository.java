package com.agroia.api.repository;

import com.agroia.api.model.Input;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputRepository extends JpaRepository<Input, String> {
    Input findById(String id);
}
