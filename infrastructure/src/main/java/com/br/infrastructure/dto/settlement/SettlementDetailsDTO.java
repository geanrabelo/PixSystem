package com.br.infrastructure.dto.settlement;

import com.br.core.entities.SettlementEntity;
import com.br.core.entities.TransactionEntity;
import com.br.core.enums.SettlementEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record SettlementDetailsDTO(UUID id, List<UUID> transactionIdList, LocalDate settlementDate, BigDecimal totalAmount, SettlementEnum settlementEnum, String batchId) {

    public SettlementDetailsDTO(SettlementEntity settlementEntity){
        this(settlementEntity.getId(),
                settlementEntity.getTransactionEntityList().stream().map(TransactionEntity::getId).toList(),
                settlementEntity.getSettlementDate(),
                settlementEntity.getTotalAmount(),
                settlementEntity.getSettlementEnum(),
                settlementEntity.getBatchId()
        );
    }
}
