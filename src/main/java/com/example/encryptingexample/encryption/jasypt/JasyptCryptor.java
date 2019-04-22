package com.example.encryptingexample.encryption.jasypt;

import com.example.encryptingexample.encryption.Decryptor;
import com.example.encryptingexample.encryption.Encryptor;
import lombok.RequiredArgsConstructor;
import org.jasypt.util.text.TextEncryptor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JasyptCryptor implements Encryptor, Decryptor {
    private final TextEncryptor textEncryptor;

    @Override
    public String decrypt(String value) {
        return textEncryptor.decrypt(value);
    }

    @Override
    public String encrypt(String value) {
        return textEncryptor.encrypt(value);
    }
}
