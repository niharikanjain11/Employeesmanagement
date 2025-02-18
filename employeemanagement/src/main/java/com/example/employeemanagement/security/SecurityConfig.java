package com.example.employeemanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for H2 Console
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/*/**").permitAll() // Allow public access to H2 Console
                .anyRequest().authenticated() // Secure other endpoints (authentication required)
            )
            .headers(headers -> headers.frameOptions().sameOrigin()); // Allow H2 Console UI to load in a frame
        return http.build();
    }
}
