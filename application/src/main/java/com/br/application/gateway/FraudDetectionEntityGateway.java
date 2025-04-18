package com.br.application.gateway;

import com.br.core.entities.FraudDetectionEntity;
import com.br.core.entities.TransactionEntity;

public interface FraudDetectionEntityGateway {
    void detectFraudUsecase(FraudDetectionEntity fraudDetectionEntity);
    void blockTransaction(TransactionEntity transactionEntity);
}
