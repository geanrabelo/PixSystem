package com.br.infrastructure.dto.settlement;

import com.br.core.entities.SettlementEntity;
import com.br.infrastructure.domain.Settlement;
import com.br.infrastructure.dto.transaction.TransactionDatabaseToEntityDTO;

public record SettlementDatabaseToEntityDTO(Settlement settlement) {

    public SettlementEntity toEntity(){
        return new SettlementEntity.SettlementEntityBuilder()
                .builder()
                .id(settlement.getId())
                .transactionEntityList(settlement
                        .getTransactionList()
                        .stream()
                        .map(t -> new TransactionDatabaseToEntityDTO(t).fromJpaToEntity())
                        .toList())
                .settlementEnum(settlement.getSettlementEnum())
                .settlementDate(settlement.getSettlementDate())
                .totalAmount(settlement.getTotalAmount())
                .batchId(settlement.getBatchId())
                .build();
    }
}
