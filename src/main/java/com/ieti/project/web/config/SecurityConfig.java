package com.ieti.project.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF usando el nuevo enfoque
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated() // Requiere autenticación para cualquier solicitud
                )
                .httpBasic(Customizer.withDefaults()); // Usar autenticación básica

        return http.build();
    }
}
