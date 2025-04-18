package com.br.infrastructure.gatewayImpl;

import com.br.application.gateway.FraudDetectionEntityGateway;
import com.br.core.entities.FraudDetectionEntity;
import com.br.core.entities.TransactionEntity;
import com.br.infrastructure.repositories.FraudDetectionRepository;
import org.springframework.stereotype.Component;

@Component
public class FraudDetectionEntityGatewayImpl implements FraudDetectionEntityGateway {

    private final FraudDetectionRepository fraudDetectionRepository;

    public FraudDetectionEntityGatewayImpl(FraudDetectionRepository fraudDetectionRepository){
        this.fraudDetectionRepository = fraudDetectionRepository;
    }

    @Override
    public void detectFraudUsecase(FraudDetectionEntity fraudDetectionEntity) {

    }

    @Override
    public void blockTransaction(TransactionEntity transactionEntity) {

    }
}
