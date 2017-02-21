package com.AdvanceSpringBootApp.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by user on 22-Feb-17.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.AdvanceSpringBootApp.backend.presistence.repositories")
@EntityScan(basePackages = "com.AdvanceSpringBootApp.backend.presistence.domain.backend")
@EnableTransactionManagement
public class ApplicationConfig {
}
