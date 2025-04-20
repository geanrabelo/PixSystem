package com.br.usecases;

import com.br.core.entities.SettlementEntity;

import java.util.List;
import java.util.UUID;

public interface SettlementEntityUsecases {

    void generateSettlementBatch(SettlementEntity settlementEntity);

    SettlementEntity findById(UUID id);

    List<SettlementEntity> findAll();
}
