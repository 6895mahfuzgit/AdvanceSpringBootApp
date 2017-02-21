package com.AdvanceSpringBootApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.AdvanceSpringBootApp.backend.presistence.repositories")
public class AdvanceSpringBootAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvanceSpringBootAppApplication.class, args);
    }
}
