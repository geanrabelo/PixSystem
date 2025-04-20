package com.br.infrastructure.dto.transaction;

import com.br.core.entities.TransactionEntity;
import com.br.infrastructure.domain.*;
import com.br.infrastructure.dto.account.AccountJpaDTO;

public record TransactionJpaDTO(TransactionEntity transactionEntity) {

    public Transaction toTransactionJpa(){
        return Transaction
                .builder()
                .id(transactionEntity.getId())
                .senderAccount(Account.builder()
                        .id(transactionEntity.getSenderAccount().getId())
                        .user(new User(transactionEntity.getSenderAccount().getUserEntity()))
                        .accountNumber(transactionEntity.getSenderAccount().getAccountNumber())
                        .agency(transactionEntity.getSenderAccount().getAgency())
                        .balance(transactionEntity.getSenderAccount().getBalance())
                        .accountType(transactionEntity.getSenderAccount().getAccountType())
                        .createdAt(transactionEntity.getSenderAccount().getCreatedAt())
                        .build())
                .receiverKey(PixKey.builder()
                        .id(transactionEntity.getReceiverKey().getId())
                        .keyValue(transactionEntity.getReceiverKey().getKeyValue())
                        .keyType(transactionEntity.getReceiverKey().getKeyType())
                        .account(new AccountJpaDTO(transactionEntity.getReceiverKey().getAccountEntity()).toAccount())
                        .createdAt(transactionEntity.getReceiverKey().getCreatedAt())
                        .active(transactionEntity.getReceiverKey().getActive())
                        .build())
                .amount(transactionEntity.getAmount())
                .transactionEnum(transactionEntity.getTransactionEnum())
                .timestamp(transactionEntity.getTimestamp())
                .endToEndId(transactionEntity.getEndToEndId())
                .description(transactionEntity.getDescription())
                .settlement(Settlement
                        .builder()
                        .id(transactionEntity.getSettlementEntity().getId())
                        .build())
                .build();
    }
}
