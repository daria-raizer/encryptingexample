package com.example.encryptingexample.controller;

import com.example.encryptingexample.service.ValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class ValueController {
    private final ValueService valueService;

    @CrossOrigin
    @PostMapping("/decrypted_values")
    public ResponseEntity<String> decrypt(@RequestBody String value) {
        return ResponseEntity.ok().body(valueService.decrypt(value));
    }

    @CrossOrigin
    @GetMapping("/values")
    public ResponseEntity<Collection<String>> getAll() {
        return ResponseEntity.ok().body(valueService.getAll());
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<String> save(@RequestBody String value) {
        return ResponseEntity.status(HttpStatus.CREATED).body(valueService.save(value));
    }
}
