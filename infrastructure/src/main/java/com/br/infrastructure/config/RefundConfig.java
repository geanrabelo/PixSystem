package com.br.infrastructure.config;

import com.br.application.gateway.RefundEntityGateway;
import com.br.application.impl.RefundEntityUsecasesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RefundConfig {

    @Bean
    public RefundEntityUsecasesImpl refundEntityUsecasesImpl(RefundEntityGateway refundEntityGateway){
        return new RefundEntityUsecasesImpl(refundEntityGateway);
    }
}
