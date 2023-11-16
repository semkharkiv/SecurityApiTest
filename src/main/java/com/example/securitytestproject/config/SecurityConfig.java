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
@EnableWebSecurity  //говорит Spring о том, что данный класс будет использоваться для настройки безопасности вашего веб-приложения.
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain defaultSecurity(HttpSecurity http) throws Exception {
        return http
                .httpBasic(Customizer.withDefaults())  // Базовая аутентификация предоставляет простой механизм аутентификации, предлагающий пользователю имя пользователя и пароль.
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/").permitAll() //Разрешает все запросы на корневой URL без аутентификации.
                        .requestMatchers(HttpMethod.POST, "/clients/create-user").permitAll()
                        .requestMatchers(HttpMethod.GET, "/clients/{id}").authenticated()
                        .requestMatchers(HttpMethod.POST, "/clients/create-manager").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/clients/manager/{name}").hasRole("ADMIN")
                        .anyRequest().permitAll()
                )
                .csrf(AbstractHttpConfigurer::disable)  //Отключает защиту от подделки межсайтовых запросов (CSRF). CSRF-атака – это атака, при которой злоумышленник использует учетные данные пользователя без его разрешения.
                .build(); // Завершает конфигурацию и создает SecurityFilterChain


    }
}
