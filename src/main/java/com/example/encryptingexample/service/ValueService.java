package com.example.encryptingexample.service;

import java.util.Collection;

public interface ValueService {
    String decrypt(String value);
    String save(String value);
    Collection<String> getAll();
}
