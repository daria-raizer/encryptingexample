package com.example.encryptingexample.encryption.jasypt;

import lombok.Setter;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.TextEncryptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jasypt")
public class JasyptConfiguration {
    @Setter
    private String password;

    @Bean
    public TextEncryptor textEncryptor() {
        BasicTextEncryptor strongTextEncryptor = new BasicTextEncryptor();
        strongTextEncryptor.setPassword(password);
        return strongTextEncryptor;
    }
}
