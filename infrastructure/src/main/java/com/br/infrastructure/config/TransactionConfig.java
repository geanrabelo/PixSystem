package com.br.infrastructure.config;

import com.br.application.gateway.TransactionEntityGateway;
import com.br.application.impl.TransactionEntityUsecasesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionConfig {

    @Bean
    public TransactionEntityUsecasesImpl transactionEntityUsecasesImpl(TransactionEntityGateway transactionEntityGateway){
        return new TransactionEntityUsecasesImpl(transactionEntityGateway);
    }
}
