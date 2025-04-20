package com.br.application.impl;

import com.br.application.gateway.SettlementEntityGateway;
import com.br.core.entities.SettlementEntity;
import com.br.usecases.SettlementEntityUsecases;

import java.util.List;
import java.util.UUID;

public class SettlementEntityUsecasesImpl implements SettlementEntityUsecases {

    private final SettlementEntityGateway settlementEntityGateway;

    public SettlementEntityUsecasesImpl(SettlementEntityGateway settlementEntityGateway){
        this.settlementEntityGateway = settlementEntityGateway;
    }
    @Override
    public void generateSettlementBatch(SettlementEntity settlementEntity) {
        settlementEntityGateway.generateSettlementBatch(settlementEntity);
    }

    @Override
    public SettlementEntity findById(UUID id) {
        return settlementEntityGateway.findById(id);
    }

    @Override
    public List<SettlementEntity> findAll() {
        return settlementEntityGateway.findAll();
    }


}
