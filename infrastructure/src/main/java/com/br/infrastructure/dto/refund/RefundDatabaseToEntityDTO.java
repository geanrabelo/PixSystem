package com.br.infrastructure.dto.refund;

import com.br.core.entities.RefundEntity;
import com.br.infrastructure.domain.Refund;
import com.br.infrastructure.dto.transaction.TransactionDatabaseToEntityDTO;

public record RefundDatabaseToEntityDTO(Refund refund) {

    public RefundEntity fromJpaToEntity(){
        return new RefundEntity.RefundEntityBuilder()
                .builder()
                .id(refund.getId())
                .transactionEntity(new TransactionDatabaseToEntityDTO(refund.getTransaction()).fromJpaToEntity())
                .amount(refund.getAmount())
                .reason(refund.getReason())
                .refundEnum(refund.getRefundEnum())
                .createdAt(refund.getCreatedAt())
                .processedAt(refund.getProcessedAt())
                .build();
    }
}
