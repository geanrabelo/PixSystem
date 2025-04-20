package com.br.application.impl;

import com.br.application.gateway.TransactionEntityGateway;
import com.br.core.entities.TransactionEntity;
import com.br.usecases.TransactionEntityUsecases;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class TransactionEntityUsecasesImpl implements TransactionEntityUsecases {

    private final TransactionEntityGateway transactionEntityGateway;

    public TransactionEntityUsecasesImpl(TransactionEntityGateway transactionEntityGateway){
        this.transactionEntityGateway = transactionEntityGateway;
    }

    @Override
    public void sendPix(TransactionEntity transactionEntity) {
        transactionEntityGateway.sendPix(transactionEntity);
    }

    @Override
    public boolean validateAmount(BigDecimal amount) {
        return transactionEntityGateway.validateAmount(amount);
    }

    @Override
    public boolean validateKey(String key) {
        return transactionEntityGateway.validateKey(key);
    }

    @Override
    public TransactionEntity findById(UUID id) {
        return transactionEntityGateway.findById(id);
    }

    @Override
    public List<TransactionEntity> findAll() {
        return transactionEntityGateway.findAll();
    }

}
