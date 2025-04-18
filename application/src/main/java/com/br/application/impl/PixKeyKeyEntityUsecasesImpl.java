package com.br.application.impl;

import com.br.application.gateway.PixKeyEntityGateway;
import com.br.core.entities.AccountEntity;
import com.br.core.entities.PixKeyEntity;
import com.br.core.enums.KeyType;
import com.br.usecases.PixKeyEntityUsecases;

import java.util.List;
import java.util.UUID;

public class PixKeyKeyEntityUsecasesImpl implements PixKeyEntityUsecases {

    private final PixKeyEntityGateway pixKeyEntityGateway;

    public PixKeyKeyEntityUsecasesImpl(PixKeyEntityGateway pixKeyEntityGateway){
        this.pixKeyEntityGateway = pixKeyEntityGateway;
    }

    @Override
    public void register(PixKeyEntity pixKeyEntity) {
        pixKeyEntityGateway.register(pixKeyEntity);
    }

    @Override
    public boolean validateKeyValue(String keyValue) {
        return pixKeyEntityGateway.validateKeyValue(keyValue);
    }

    @Override
    public boolean existsById(UUID id) {
        return pixKeyEntityGateway.existsById(id);
    }

    @Override
    public boolean existsTransactions() {
        return pixKeyEntityGateway.existsTransactions();
    }

    @Override
    public List<PixKeyEntity> findAll() {
        return pixKeyEntityGateway.findAll();
    }

    @Override
    public List<PixKeyEntity> findByAccount(AccountEntity accountEntity) {
        return pixKeyEntityGateway.findByAccount(accountEntity);
    }

    @Override
    public PixKeyEntity findById(UUID id) {
        return pixKeyEntityGateway.findById(id);
    }

    @Override
    public PixKeyEntity findByKeyValue(String keyValue) {
        return pixKeyEntityGateway.findByKeyValue(keyValue);
    }

    @Override
    public void delete(UUID id) {
        pixKeyEntityGateway.delete(id);
    }
}
