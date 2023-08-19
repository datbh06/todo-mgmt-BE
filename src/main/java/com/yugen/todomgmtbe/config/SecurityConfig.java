package com.yugen.todomgmtbe.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * This class represents the security configuration for the TodoAPI.
 */
@Configuration
@EnableMethodSecurity
@AllArgsConstructor
public class SecurityConfig {

    /**
     * Configures the security filter chain.
     *
     * @param http the HttpSecurity object
     * @return the configured SecurityFilterChain object
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests((authorize) -> {
            authorize.requestMatchers("/api/v1/auth/**").permitAll();
            authorize.anyRequest().authenticated();
        }).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    /**
     * Configures the authentication manager.
     *
     * @param configuration the AuthenticationConfiguration object
     * @return the configured AuthenticationManager object
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    /**
     * Configures the password encoder.
     *
     * @return the configured PasswordEncoder object
     */
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
