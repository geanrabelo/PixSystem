package com.br.application.gateway;

import com.br.core.entities.TransactionEntity;

import java.math.BigDecimal;

public interface TransactionEntityGateway {

    void sendPix(TransactionEntity transactionEntity);

    boolean validateAmount(BigDecimal amount);

    boolean validateKey(String key);

    void processReceivePix(TransactionEntity transactionEntity);

}
