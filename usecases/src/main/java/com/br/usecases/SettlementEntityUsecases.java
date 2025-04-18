package com.br.usecases;

import com.br.core.entities.SettlementEntity;

import java.util.List;

public interface SettlementEntityUsecases {
    void generateSettlementBatch(SettlementEntity settlementEntity);
    void sendSettlementToBacen(String centralBank);
}
