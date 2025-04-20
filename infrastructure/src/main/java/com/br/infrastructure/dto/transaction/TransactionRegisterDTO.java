package com.br.infrastructure.dto.transaction;

import com.br.core.entities.TransactionEntity;

import java.math.BigDecimal;

public record TransactionRegisterDTO(String senderAccountId,
                                     String receiverKey,
                                     BigDecimal amount,
                                     String description,
                                     String settlementId) {
}
