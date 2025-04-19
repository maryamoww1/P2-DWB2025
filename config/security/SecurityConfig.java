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
                // Category (antes Region)
                .requestMatchers(HttpMethod.GET, "/category/active").hasAnyAuthority("ADMIN", "PRODUCT")
                .requestMatchers("/category/**").hasAuthority("ADMIN")

                // Product
                .requestMatchers(HttpMethod.GET, "/product/*").hasAnyAuthority("ADMIN", "PRODUCT")
                .requestMatchers("/product/**").hasAuthority("ADMIN")

                // Product images
                .requestMatchers("/product-image/**").hasAnyAuthority("ADMIN", "PRODUCT")

                // Por defecto, todo lo demás solo lo puede acceder ADMIN
                .anyRequest().hasAuthority("ADMIN")
            )
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
