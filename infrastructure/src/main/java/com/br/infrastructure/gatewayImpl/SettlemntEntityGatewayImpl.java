package com.br.infrastructure.gatewayImpl;

import com.br.application.gateway.SettlementEntityGateway;
import com.br.core.entities.SettlementEntity;
import com.br.infrastructure.repositories.SettlementRepository;
import org.springframework.stereotype.Component;

@Component
public class SettlemntEntityGatewayImpl implements SettlementEntityGateway {

    private final SettlementRepository settlementRepository;

    public SettlemntEntityGatewayImpl(SettlementRepository settlementRepository){
        this.settlementRepository = settlementRepository;
    }

    @Override
    public void generateSettlementBatch(SettlementEntity settlementEntity) {

    }

    @Override
    public void sendSettlementToBacen(String centralBank) {

    }
}
