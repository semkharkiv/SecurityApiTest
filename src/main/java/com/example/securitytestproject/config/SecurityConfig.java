package com.example.securitytestproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain defaultSecurity(HttpSecurity http) throws Exception {
        return http
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/").permitAll()
                        .requestMatchers(HttpMethod.POST, "/clients/create-user").permitAll()
                        .requestMatchers(HttpMethod.GET, "/clients/{id}").authenticated()
                        .requestMatchers(HttpMethod.POST, "/clients/create-manager").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/clients/manager/{name}").hasRole("ADMIN")
                        .anyRequest().permitAll() // -это тоже не особо надо,так как у меня нету более котроллеров
                )
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }
}
