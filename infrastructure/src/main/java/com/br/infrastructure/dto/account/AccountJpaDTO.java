package com.br.infrastructure.dto.account;

import com.br.core.entities.AccountEntity;
import com.br.infrastructure.domain.Account;
import com.br.infrastructure.domain.User;
import com.br.infrastructure.dto.user.UserJpaDTO;

public record AccountJpaDTO(AccountEntity accountEntity) {

    public Account toAccount(){
        return Account.builder()
                .id(accountEntity.getId())
                .user(new User(accountEntity.getUserEntity()))
                .accountNumber(accountEntity.getAccountNumber())
                .agency(accountEntity.getAgency())
                .balance(accountEntity.getBalance())
                .accountType(accountEntity.getAccountType())
                .createdAt(accountEntity.getCreatedAt())
                .build();
    }

    public Account toAccountWithoutUser(){
        return Account.builder()
                .id(accountEntity.getId())
                .user(null)
                .accountNumber(accountEntity.getAccountNumber())
                .agency(accountEntity.getAgency())
                .balance(accountEntity.getBalance())
                .accountType(accountEntity.getAccountType())
                .createdAt(accountEntity.getCreatedAt())
                .build();
    }
}
