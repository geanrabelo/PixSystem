package com.br.application.impl;

import com.br.application.gateway.AccountEntityGateway;
import com.br.core.entities.AccountEntity;
import com.br.usecases.AccountEntityUsecases;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class AccountEntityUsecasesImpl implements AccountEntityUsecases {

    private final AccountEntityGateway accountEntityGateway;

    public AccountEntityUsecasesImpl(AccountEntityGateway accountEntityGateway){
        this.accountEntityGateway = accountEntityGateway;
    }

    @Override
    public void register(AccountEntity accountEntity) {
        accountEntityGateway.register(accountEntity);
    }

    @Override
    public void saveData(UUID id, BigDecimal balance) {
        accountEntityGateway.saveData(id, balance);
    }


    @Override
    public List<AccountEntity> findAll() {
        return accountEntityGateway.findAll();
    }

    @Override
    public AccountEntity findById(UUID id) {
        return accountEntityGateway.findById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return accountEntityGateway.existsById(id);
    }

    @Override
    public void delete(UUID id) {
        accountEntityGateway.delete(id);
    }
}
