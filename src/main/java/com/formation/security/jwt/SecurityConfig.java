package com.formation.security.jwt;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    protected void configure(HttpSecurity http) throws Exception {
        http
            // Other configurations...
            .logout()
                .logoutUrl("/logout") // Configure the logout URL
                .logoutSuccessUrl("/api/v1/login") // Redirect to login page after successful logout
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID"); // Delete cookies upon logout if any
    }
}
