package com.br.infrastructure.config;

import com.br.application.gateway.PixKeyEntityGateway;
import com.br.application.impl.PixKeyKeyEntityUsecasesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PixKeyConfig {

    @Bean
    public PixKeyKeyEntityUsecasesImpl pixKeyEntityUsecasesImpl(PixKeyEntityGateway pixKeyEntityGateway){
        return new PixKeyKeyEntityUsecasesImpl(pixKeyEntityGateway);
    }
}
