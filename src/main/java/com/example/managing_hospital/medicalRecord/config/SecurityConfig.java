package com.example.managing_hospital.medicalRecord.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // CSRF 보호 비활성화
                .authorizeRequests()
                .requestMatchers("/api/medical-records/**").permitAll()  // /api/medical-records/** 경로에 대해 인증 없이 접근 허용
                .anyRequest().permitAll()  // 나머지 요청도 인증 없이 접근 허용
                .and()
                .httpBasic().disable()    // HTTP Basic 인증 비활성화
                .formLogin().disable();   // 폼 로그인 비활성화
        return http.build();
    }
}
