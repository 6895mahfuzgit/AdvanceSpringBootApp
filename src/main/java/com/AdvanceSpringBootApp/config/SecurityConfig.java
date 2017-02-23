package com.AdvanceSpringBootApp.config;

import com.AdvanceSpringBootApp.backend.service.UserSecurityService;
import com.AdvanceSpringBootApp.web.controllers.ForgotPasswordController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 21-Feb-17.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserSecurityService userSecurityService;

    @Autowired
    private Environment environment;

    private static final String SALT = "dgvdfhbfdgh'./;'.;.jf";


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));

    }

    private static final String[] PUBLIC_MATCHES = {

            "/webjars/**",
            "/css/**",
            "/js/**",
            "/images/**",
            "/",
            "/about/**",
            "/contact/**",
            "/error/**/*",
            "/console/**",
            ForgotPasswordController.FORGOT_PASSWORD_URL_MAPPING,


    };

    @Override
    protected void configure(HttpSecurity security) throws Exception {

        List<String> activeProfiles = Arrays.asList(environment.getActiveProfiles());
        if (activeProfiles.contains("dev")) {
            security.csrf().disable();
            security.headers().frameOptions().disable();
        }


        security
                .authorizeRequests()
                .antMatchers(PUBLIC_MATCHES).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/payload")
                .failureUrl("/login?error").permitAll()
                .and()
                .logout().permitAll();


    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder autho) throws Exception {

        autho
                .userDetailsService(userSecurityService)
                .passwordEncoder(passwordEncoder());

    }


}
