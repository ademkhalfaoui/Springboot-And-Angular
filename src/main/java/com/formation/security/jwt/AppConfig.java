package com.formation.security.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

import com.formation.validationdeSasie.ParticipantValidator;

@Configuration
public class AppConfig extends WsConfigurerAdapter {

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor((HandlerInterceptor) participantValidator());
    }

    @Bean
    ParticipantValidator participantValidator() {
        return new ParticipantValidator();
    }
}
