package com.unam.dwb.auth.config.security;

import com.unam.dwb.auth.filter.JwtAuthFilter;
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
            .cors()
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeHttpRequests(auth -> auth
                // Region
                .requestMatchers(HttpMethod.GET, "/region/active").hasAnyAuthority("ADMIN", "PRODUCT")
                .requestMatchers("/region/**").hasAuthority("ADMIN")

                // Product (antes era Customer)
                .requestMatchers(HttpMethod.GET, "/product/*").hasAnyAuthority("ADMIN", "PRODUCT")
                .requestMatchers("/product/**").hasAuthority("ADMIN")

                // Product images (antes era Customer images)
                .requestMatchers("/product-image/**").hasAnyAuthority("ADMIN", "PRODUCT")

                // Categorías activas
                .requestMatchers(HttpMethod.GET, "/category/active").hasAnyAuthority("ADMIN", "PRODUCT")

                // Todo lo demás, acceso restringido a ADMIN
                .anyRequest().hasAuthority("ADMIN")
            )
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
