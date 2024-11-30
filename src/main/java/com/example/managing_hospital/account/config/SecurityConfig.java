package com.example.managing_hospital.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration("accountSecurityConfig")
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/doctor/signup",
                                "/nurse/signup",
                                "/doctor/login",
                                "/nurse/login",
                                "api/materials/**",
                                "/medical-records/**",
                                "/hospitalmanager/**",
                                "/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login.disable()
                )
                .httpBasic(HttpBasicConfigurer::disable);

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
