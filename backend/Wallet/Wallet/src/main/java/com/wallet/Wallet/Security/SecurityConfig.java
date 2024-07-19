package com.wallet.Wallet.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthConverter jwtAuthConverter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authorizeRequests -> 
        authorizeRequests
        .anyRequest().authenticated()
    );
    http
    .oauth2ResourceServer(oauth2 -> 
    oauth2.jwt(jwt -> jwt.decoder(JwtDecoders.fromIssuerLocation("http://localhost:9090/realms/Wallet-App"))
    .jwtAuthenticationConverter(jwtAuthConverter)
    )
    );
    http
    .sessionManagement(sessionManagement -> 
        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    );

    return http.build();
    }
}