package com.br.infrastructure.config;

import com.br.application.gateway.AccountEntityGateway;
import com.br.application.impl.AccountEntityUsecasesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfig {

    @Bean
    public AccountEntityUsecasesImpl accountEntityUsecasesImpl(AccountEntityGateway accountEntityGateway){
        return new AccountEntityUsecasesImpl(accountEntityGateway);
    }
}
