package com.unam.dwb.auth.config.security;

import com.unam.dwb.auth.config.jwt.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf().disable()
            .cors() // usa tu CorsConfig
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeHttpRequests(auth -> auth
                // Region
                .requestMatchers(HttpMethod.GET, "/region/active").hasAnyAuthority("ADMIN", "CUSTOMER")
                .requestMatchers("/region/**").hasAuthority("ADMIN")

                // Customer
                .requestMatchers(HttpMethod.GET, "/customer/*").hasAnyAuthority("ADMIN", "CUSTOMER")
                .requestMatchers("/customer/**").hasAuthority("ADMIN")

                // Customer images
                .requestMatchers("/customer-image/**").hasAnyAuthority("ADMIN", "CUSTOMER")

                // Categorías activas y productos (p7_login)
                .requestMatchers(HttpMethod.GET, "/category/active").hasAnyAuthority("ADMIN", "CUSTOMER")
                .requestMatchers(HttpMethod.GET, "/product/*").hasAnyAuthority("ADMIN", "CUSTOMER")
                .requestMatchers(HttpMethod.GET, "/product-image/**").hasAnyAuthority("ADMIN", "CUSTOMER")

                // Por defecto, todo lo demás solo lo puede acceder ADMIN
                .anyRequest().hasAuthority("ADMIN")
            )
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
