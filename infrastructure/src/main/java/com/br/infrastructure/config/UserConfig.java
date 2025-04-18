package com.br.infrastructure.config;

import com.br.application.gateway.UserEntityGateway;
import com.br.application.impl.UserEntityUsecasesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public UserEntityUsecasesImpl userEntityUsecasesImpl(UserEntityGateway userEntityGateway){
        return new UserEntityUsecasesImpl(userEntityGateway);
    }
}
