package com.raizes.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// Configuração de segurança do sistema
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        // Swagger liberado
                        .requestMatchers(
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**"
                        ).permitAll()

                        // Cadastro e login liberados
                        .requestMatchers("/usuarios", "/usuarios/login").permitAll()

                        // Consulta de produtos liberada
                        .requestMatchers("GET", "/produtos").permitAll()

                        // Somente ADMIN pode criar/alterar produtos
                        .requestMatchers("POST", "/produtos").hasRole("ADMIN")

                        // CLIENTE ou ADMIN podem criar pedidos e itens
                        .requestMatchers("/pedidos/**").hasAnyRole("CLIENTE", "ADMIN")
                        .requestMatchers("/itens/**").hasAnyRole("CLIENTE", "ADMIN")

                        // Somente ADMIN pode acessar pagamentos
                        .requestMatchers("/pagamentos/**").hasRole("ADMIN")

                        // Qualquer outra rota precisa estar logado
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {});

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}