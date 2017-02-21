package com.AdvanceSpringBootApp.config;

import com.AdvanceSpringBootApp.backend.service.EmailService;
import com.AdvanceSpringBootApp.backend.service.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by user on 21-Feb-17.
 */
@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/application-prod.properties")
public class ProductionConfig {

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }
}
