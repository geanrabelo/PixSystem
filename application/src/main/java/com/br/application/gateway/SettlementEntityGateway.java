package com.br.application.gateway;

import com.br.core.entities.SettlementEntity;
import com.br.core.entities.TransactionEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface SettlementEntityGateway {

    void generateSettlementBatch(SettlementEntity settlementEntity);

    SettlementEntity findById(UUID id);

    List<SettlementEntity> findAll();

    void updateAmount(BigDecimal value, UUID id);
}
