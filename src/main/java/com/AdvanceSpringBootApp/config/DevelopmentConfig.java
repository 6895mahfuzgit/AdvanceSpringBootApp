package com.AdvanceSpringBootApp.config;

import com.AdvanceSpringBootApp.backend.service.EmailService;
import com.AdvanceSpringBootApp.backend.service.MockEmailService;
import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by user on 21-Feb-17.
 */
@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/application-dev.properties")
public class DevelopmentConfig {


    @Bean
    public EmailService emailService() {
        return new MockEmailService();
    }

    @Bean
    public ServletRegistrationBean h2ServletRegistrationBean() {


        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new WebdavServlet());

        servletRegistrationBean.addUrlMappings("/console/**");
        return servletRegistrationBean;
    }


}
