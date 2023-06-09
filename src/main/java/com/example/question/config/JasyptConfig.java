package com.example.question.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {

    private final String PASSWORD = "ghatyvldwkfgofk!";

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(PASSWORD);   // 암호화 할 때 사용하는 키
        config.setPoolSize("1");        // 인스턴스 pool
        config.setAlgorithm("PBEWithMD5AndDES");    // 암호화 알고리즘
        config.setStringOutputType("base64");   // 인코딩 방식
        config.setKeyObtentionIterations("1000");   // 반복할 해싱 회수
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");    // salt 생성 클래스
        encryptor.setConfig(config);
        return encryptor;
    }
}
