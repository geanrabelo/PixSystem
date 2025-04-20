package com.br.usecases;

import com.br.core.entities.TransactionEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface TransactionEntityUsecases {

    void sendPix(TransactionEntity transactionEntity);

    boolean validateAmount(BigDecimal amount);

    boolean validateKey(String key);

    TransactionEntity findById(UUID id);

    List<TransactionEntity> findAll();
}
