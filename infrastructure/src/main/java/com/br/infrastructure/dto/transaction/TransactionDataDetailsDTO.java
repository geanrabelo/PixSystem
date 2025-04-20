package com.br.infrastructure.dto.transaction;

import com.br.core.entities.TransactionEntity;
import com.br.core.enums.TransactionEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionDataDetailsDTO(UUID id, UUID accountId, String receiverKeyValue, BigDecimal amount, TransactionEnum transactionEnum,
                                        LocalDateTime timestamp,
                                        String endToEndId,
                                        String description,
                                        UUID settlementId) {

    public TransactionDataDetailsDTO(TransactionEntity transactionEntity){
        this(transactionEntity.getId(),
                transactionEntity.getSenderAccount().getId(),
                transactionEntity.getReceiverKey().getKeyValue(),
                transactionEntity.getAmount(),
                transactionEntity.getTransactionEnum(),
                transactionEntity.getTimestamp(),
                transactionEntity.getEndToEndId(),
                transactionEntity.getDescription(),
                transactionEntity.getSettlementEntity().getId()
        );
    }
}
