package com.example.encryptingexample.repository;

import com.example.encryptingexample.entity.ValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValueRepository extends JpaRepository<ValueEntity, Long> {
}
