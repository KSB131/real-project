package com.quadcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * QuadCore - 욕창방지 관제 시스템
 * Spring Boot 메인 애플리케이션
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // Spring Boot 애플리케이션 시작
        SpringApplication.run(Application.class, args);
    }
}
