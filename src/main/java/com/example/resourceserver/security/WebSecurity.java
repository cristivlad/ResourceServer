package com.example.resourceserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class WebSecurity {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpRequest) throws Exception {
        httpRequest
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/users").hasAuthority("SCOPE_profile")
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer().jwt();
        return httpRequest.build();
    }
}
