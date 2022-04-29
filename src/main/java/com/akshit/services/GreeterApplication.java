package com.akshit.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class GreeterApplication {
    public static void main(String[] args) {
        SpringApplication.run(GreeterApplication.class, args);
    }
}
