package com.br.infrastructure.config;

import com.br.application.gateway.SettlementEntityGateway;
import com.br.application.impl.SettlementEntityUsecasesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SettlementConfig {

    @Bean
    public SettlementEntityUsecasesImpl settlementEntityUsecasesImpl(SettlementEntityGateway settlementEntityGateway){
        return new SettlementEntityUsecasesImpl(settlementEntityGateway);
    }
}
