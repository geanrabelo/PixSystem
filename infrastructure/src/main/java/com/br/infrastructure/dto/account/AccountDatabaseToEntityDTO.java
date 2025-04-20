package com.br.infrastructure.dto.account;

import com.br.core.entities.AccountEntity;
import com.br.core.entities.PixKeyEntity;
import com.br.core.entities.TransactionEntity;
import com.br.infrastructure.domain.Account;
import com.br.infrastructure.dto.pixKey.PixKeyDatabaseToEntityDTO;
import com.br.infrastructure.dto.user.UserDatabaseToEntityDTO;

public record AccountDatabaseToEntityDTO(Account account) {

    public AccountEntity fromJpaForEntity(){
        return new AccountEntity.AccountEntityBuilder()
                .builder()
                .id(account.getId())
                .userEntity(new UserDatabaseToEntityDTO(account.getUser()).fromJpaForEntity())
                .accountNumber(account.getAccountNumber())
                .agency(account.getAgency())
                .balance(account.getBalance())
                .accountType(account.getAccountType())
                .createdAt(account.getCreatedAt())
                .pixKeyEntityList(account.getPixKeyList().stream().map(p ->
                        new PixKeyEntity.PixKeyBuilder()
                                .builder()
                                .id(p.getId())
                                .keyValue(p.getKeyValue())
                                .keyType(p.getKeyType())
                                .createdAt(p.getCreatedAt())
                                .active(p.getActive())
                                .build()).toList())
                .transactionEntityList(account.getTransactionList().stream().map(t ->
                        new TransactionEntity.TransactionEntityBuilder()
                                .builder()
                                .id(t.getId())
                                .senderAccount(new AccountEntity.AccountEntityBuilder()
                                        .builder()
                                        .id(account.getId())
                                        .userEntity(new UserDatabaseToEntityDTO(account.getUser()).fromJpaForEntity())
                                        .accountNumber(account.getAccountNumber())
                                        .agency(account.getAgency())
                                        .balance(account.getBalance())
                                        .accountType(account.getAccountType())
                                        .createdAt(account.getCreatedAt())
                                        .build())
                                .receiverKey(new PixKeyEntity.PixKeyBuilder()
                                        .builder()
                                        .id(t.getReceiverKey().getId())
                                        .keyValue(t.getReceiverKey().getKeyValue())
                                        .keyType(t.getReceiverKey().getKeyType())
                                        .accountEntity(null)
                                        .createdAt(t.getReceiverKey().getCreatedAt())
                                        .active(t.getReceiverKey().getActive())
                                        .build())
                                .amount(t.getAmount())
                                .transactionEnum(t.getTransactionEnum())
                                .timestamp(t.getTimestamp())
                                .endToEndId(t.getEndToEndId())
                                .description(t.getDescription())
                                .build()).toList())
                .build();
    }
}
