package com.br.infrastructure.dto.transaction;

import com.br.core.entities.SettlementEntity;
import com.br.core.entities.TransactionEntity;
import com.br.infrastructure.domain.Transaction;
import com.br.infrastructure.dto.account.AccountDatabaseToEntityDTO;
import com.br.infrastructure.dto.pixKey.PixKeyDatabaseToEntityDTO;

public record TransactionDatabaseToEntityDTO(Transaction transaction) {

    public TransactionEntity fromJpaToEntity(){
        return new TransactionEntity.TransactionEntityBuilder()
                .builder()
                .id(transaction.getId())
                .senderAccount(new AccountDatabaseToEntityDTO(transaction.getSenderAccount()).fromJpaForEntity())
                .receiverKey(new PixKeyDatabaseToEntityDTO(transaction.getReceiverKey()).fromJpaForEntity())
                .amount(transaction.getAmount())
                .transactionEnum(transaction.getTransactionEnum())
                .timestamp(transaction.getTimestamp())
                .endToEndId(transaction.getEndToEndId())
                .description(transaction.getDescription())
                .settlementEntity(new SettlementEntity.SettlementEntityBuilder()
                        .builder()
                        .id(transaction.getSettlement().getId())
                        .build())
                .build();
    }
}
