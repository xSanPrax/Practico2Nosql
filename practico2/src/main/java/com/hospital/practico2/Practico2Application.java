package com.hospital.practico2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Practico2Application {

    public static void main(String[] args) {
        SpringApplication.run(Practico2Application.class, args);
    }
}
