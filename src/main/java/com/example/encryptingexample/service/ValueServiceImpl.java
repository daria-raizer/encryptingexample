package com.example.encryptingexample.service;

import com.example.encryptingexample.encryption.Decryptor;
import com.example.encryptingexample.encryption.Encryptor;
import com.example.encryptingexample.entity.ValueEntity;
import com.example.encryptingexample.repository.ValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ValueServiceImpl implements ValueService {
    private final ValueRepository valueRepository;
    private final Encryptor encryptor;
    private final Decryptor decryptor;

    @Override
    public String decrypt(String value) {
        String decrypt = decryptor.decrypt(value);
        return decrypt.substring(1, decrypt.length() - 1);
    }

    @Override
    public String save(String value) {
        String encryptedValue = encryptor.encrypt(value);
        ValueEntity valueEntity = new ValueEntity();
        valueEntity.setValue(encryptedValue);
        return valueRepository.save(valueEntity).getValue();
    }

    @Override
    public Collection<String> getAll() {
        return valueRepository.findAll().stream().map(ValueEntity::getValue).collect(Collectors.toList());
    }
}
