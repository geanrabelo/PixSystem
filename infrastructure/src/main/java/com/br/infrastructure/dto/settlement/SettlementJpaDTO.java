package com.br.infrastructure.dto.settlement;

import com.br.core.entities.SettlementEntity;
import com.br.infrastructure.domain.Settlement;
import com.br.infrastructure.dto.transaction.TransactionJpaDTO;

public record SettlementJpaDTO(SettlementEntity settlementEntity) {

    public Settlement toSettlementJpa(){
        return Settlement
                .builder()
                .id(settlementEntity.getId())
                .transactionList(settlementEntity.getTransactionEntityList().stream().map(t -> new TransactionJpaDTO(t).toTransactionJpa()).toList())
                .settlementDate(settlementEntity.getSettlementDate())
                .totalAmount(settlementEntity.getTotalAmount())
                .settlementEnum(settlementEntity.getSettlementEnum())
                .batchId(settlementEntity.getBatchId())
                .build();

    }
}
