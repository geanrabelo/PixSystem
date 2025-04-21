package com.br.core.entities;

import com.br.core.enums.RefundEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class RefundEntity {

    public RefundEntity(UUID id, TransactionEntity transactionEntity, BigDecimal amount, String reason, RefundEnum refundEnum, LocalDateTime createdAt, LocalDateTime processedAt) {
        this.id = id;
        this.transactionEntity = transactionEntity;
        this.amount = amount;
        this.reason = reason;
        this.refundEnum = refundEnum;
        this.createdAt = createdAt;
        this.processedAt = processedAt;
    }

    private UUID id;
    private TransactionEntity transactionEntity;
    private BigDecimal amount;
    private String reason;
    private RefundEnum refundEnum;
    private LocalDateTime createdAt;
    private LocalDateTime processedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TransactionEntity getTransactionEntity() {
        return transactionEntity;
    }

    public void setTransactionEntity(TransactionEntity transactionEntity) {
        this.transactionEntity = transactionEntity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public RefundEnum getRefundEnum() {
        return refundEnum;
    }

    public void setRefundEnum(RefundEnum refundEnum) {
        this.refundEnum = refundEnum;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(LocalDateTime processedAt) {
        this.processedAt = processedAt;
    }
    public static class RefundEntityBuilder{
        private UUID id;
        private TransactionEntity transactionEntity;
        private BigDecimal amount;
        private String reason;
        private RefundEnum refundEnum;
        private LocalDateTime createdAt;
        private LocalDateTime processedAt;

        public RefundEntityBuilder builder(){
            return new RefundEntityBuilder();
        }

        public RefundEntityBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public RefundEntityBuilder transactionEntity(TransactionEntity transactionEntity) {
            this.transactionEntity = transactionEntity;
            return this;
        }

        public RefundEntityBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;

        }

        public RefundEntityBuilder reason(String reason) {
            this.reason = reason;
            return this;

        }

        public RefundEntityBuilder refundEnum(RefundEnum refundEnum) {
            this.refundEnum = refundEnum;
            return this;

        }

        public RefundEntityBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public RefundEntityBuilder processedAt(LocalDateTime processedAt) {
            this.processedAt = processedAt;
            return this;
        }

        public RefundEntity build(){
            return new RefundEntity(this.id, this.transactionEntity, this.amount, this.reason, this.refundEnum, this.createdAt, this.processedAt);
        }
    }
}
