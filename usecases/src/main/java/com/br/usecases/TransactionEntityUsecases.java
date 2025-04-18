package com.br.usecases;

import com.br.core.entities.TransactionEntity;

import java.math.BigDecimal;

public interface TransactionEntityUsecases {

    void sendPix(TransactionEntity transactionEntity);

    boolean validateAmount(BigDecimal amount);

    boolean validateKey(String key);

    void processReceivePix(TransactionEntity transactionEntity);
}
