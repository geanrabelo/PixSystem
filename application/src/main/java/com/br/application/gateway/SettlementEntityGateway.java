package com.br.application.gateway;

import com.br.core.entities.SettlementEntity;

public interface SettlementEntityGateway {

    void generateSettlementBatch(SettlementEntity settlementEntity);
    void sendSettlementToBacen(String centralBank);

}
