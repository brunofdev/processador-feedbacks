package com.processador_feedbacks.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilita CSRF, essencial para APIs REST
                .authorizeHttpRequests(auth -> auth
                        // Permite acesso público e anônimo ao nosso endpoint de login
                        .requestMatchers("/api/processfeedback/**").permitAll()
                        // Qualquer outra rota neste serviço será bloqueada (boa prática de segurança)
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}