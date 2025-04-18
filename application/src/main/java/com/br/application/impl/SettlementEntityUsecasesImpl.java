package com.br.application.impl;

import com.br.application.gateway.SettlementEntityGateway;
import com.br.core.entities.SettlementEntity;
import com.br.usecases.SettlementEntityUsecases;

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
    public void sendSettlementToBacen(String centralBank) {
        settlementEntityGateway.sendSettlementToBacen(centralBank);
    }
}
