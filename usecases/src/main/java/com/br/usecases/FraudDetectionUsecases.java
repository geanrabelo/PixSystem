package com.br.usecases;

import com.br.core.entities.FraudDetectionEntity;
import com.br.core.entities.TransactionEntity;

public interface FraudDetectionUsecases {

    void detectFraudUsecase(FraudDetectionEntity fraudDetectionEntity);
    void blockTransaction(TransactionEntity transactionEntity);
}
