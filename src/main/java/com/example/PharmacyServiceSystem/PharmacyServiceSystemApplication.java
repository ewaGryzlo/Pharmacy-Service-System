package com.example.PharmacyServiceSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={"com.example.PharmacyServiceSystem.api.EmployeeController"})
public class PharmacyServiceSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PharmacyServiceSystemApplication.class, args);
    }
}
