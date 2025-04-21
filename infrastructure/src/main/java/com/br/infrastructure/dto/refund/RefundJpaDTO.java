package com.br.infrastructure.dto.refund;

import com.br.core.entities.RefundEntity;
import com.br.infrastructure.domain.Refund;
import com.br.infrastructure.dto.transaction.TransactionJpaDTO;

public record RefundJpaDTO(RefundEntity refundEntity) {

    public Refund toJpa(){
        return Refund.builder()
                .id(refundEntity.getId())
                .transaction(new TransactionJpaDTO(refundEntity.getTransactionEntity()).toTransactionJpa())
                .amount(refundEntity.getAmount())
                .reason(refundEntity.getReason())
                .refundEnum(refundEntity.getRefundEnum())
                .createdAt(refundEntity.getCreatedAt())
                .processedAt(refundEntity.getProcessedAt())
                .build();
    }
}
