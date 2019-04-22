package com.example.encryptingexample.service;

import com.example.encryptingexample.encryption.Decryptor;
import com.example.encryptingexample.encryption.Encryptor;
import com.example.encryptingexample.entity.ValueEntity;
import com.example.encryptingexample.repository.ValueRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ValueServiceImplTest {
    @Mock
    private ValueRepository valueRepository;
    @Mock
    private Encryptor encryptor;
    @Mock
    private Decryptor decryptor;
    @InjectMocks
    private ValueServiceImpl valueService;

    @Test
    public void testDecrypt() {
        String encrypted_value = "encrypted_value";
        when(decryptor.decrypt(encrypted_value)).thenReturn("\"decrypted_value\"");
        assertEquals("decrypted_value", valueService.decrypt(encrypted_value));
        verify(decryptor, times(1)).decrypt(encrypted_value);
    }

    @Test
    public void testEncrypt() {
        String encryptedValue = "encrypted_value";
        String decryptedValue = "decrypted_value";
        when(encryptor.encrypt(decryptedValue)).thenReturn(encryptedValue);
        ValueEntity valueEntity = new ValueEntity();
        valueEntity.setValue(encryptedValue);
        when(valueRepository.save(valueEntity)).thenReturn(valueEntity);
        assertEquals(encryptedValue, valueService.save(decryptedValue));
        verify(encryptor, times(1)).encrypt(decryptedValue);
        verify(valueRepository, times(1)).save(valueEntity);
    }

    @Test
    public void getAll() {
        ArrayList<ValueEntity> valueEntities = new ArrayList<>();
        valueEntities.add(new ValueEntity(1L, "name1"));
        valueEntities.add(new ValueEntity(2L, "name2"));
        when(valueRepository.findAll()).thenReturn(valueEntities);
        ArrayList<String> values = new ArrayList<>();
        values.add("name1");
        values.add("name2");
        assertEquals(values, valueService.getAll());
        verify(valueRepository, times(1)).findAll();
    }
}
