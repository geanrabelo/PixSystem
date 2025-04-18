package com.br.application.impl;

import com.br.application.gateway.FraudDetectionEntityGateway;
import com.br.core.entities.FraudDetectionEntity;
import com.br.core.entities.TransactionEntity;
import com.br.usecases.FraudDetectionUsecases;

public class FraudDetectionEntityUsecasesImpl implements FraudDetectionUsecases {

    private final FraudDetectionEntityGateway fraudDetectionEntityGateway;

    public FraudDetectionEntityUsecasesImpl(FraudDetectionEntityGateway fraudDetectionEntityGateway){
        this.fraudDetectionEntityGateway = fraudDetectionEntityGateway;
    }

    @Override
    public void detectFraudUsecase(FraudDetectionEntity fraudDetectionEntity) {
        fraudDetectionEntityGateway.detectFraudUsecase(fraudDetectionEntity);
    }

    @Override
    public void blockTransaction(TransactionEntity transactionEntity) {
        fraudDetectionEntityGateway.blockTransaction(transactionEntity);
    }
}
