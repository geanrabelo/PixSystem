package com.br.infrastructure.dto.refund;

import com.br.core.entities.RefundEntity;
import com.br.core.enums.RefundEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record RefundDetailsDTO(UUID id, UUID transactionId, BigDecimal amount, String reason, RefundEnum refundEnum, LocalDateTime createdAt, LocalDateTime processedAt) {

    public RefundDetailsDTO(RefundEntity refundEntity){
        this(refundEntity.getId(),
                refundEntity.getTransactionEntity().getId(),
                refundEntity.getAmount(),
                refundEntity.getReason(),
                refundEntity.getRefundEnum(),
                refundEntity.getCreatedAt(),
                refundEntity.getProcessedAt());
    }
}
