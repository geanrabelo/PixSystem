package com.br.core.entities;

import com.br.core.entities.TransactionEntity;
import com.br.core.enums.SettlementEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class SettlementEntity {

    public SettlementEntity(UUID id, List<TransactionEntity> transactionEntityList, LocalDate settlementDate, BigDecimal totalAmount, SettlementEnum settlementEnum, String batchId) {
        this.id = id;
        this.transactionEntityList = transactionEntityList;
        this.settlementDate = settlementDate;
        this.totalAmount = totalAmount;
        this.settlementEnum = SettlementEnum.SETTLED;
        this.batchId = UUID.randomUUID().toString();
    }

    private UUID id;
    private List<TransactionEntity> transactionEntityList;
    private LocalDate settlementDate;
    private BigDecimal totalAmount;
    private SettlementEnum settlementEnum;
    private String batchId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<TransactionEntity> getTransactionEntityList() {
        return transactionEntityList;
    }

    public void setTransactionEntityList(List<TransactionEntity> transactionEntityList5) {
        this.transactionEntityList = transactionEntityList5;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(LocalDate settlementDate) {
        this.settlementDate = settlementDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public SettlementEnum getSettlementEnum() {
        return settlementEnum;
    }

    public void setSettlementEnum(SettlementEnum settlementEnum) {
        this.settlementEnum = settlementEnum;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }
    public static class SettlementEntityBuilder{
        private UUID id;
        private List<TransactionEntity> transactionEntityList;
        private LocalDate settlementDate;
        private BigDecimal totalAmount;
        private SettlementEnum settlementEnum;
        private String batchId;

        public SettlementEntityBuilder builder(){
            return new SettlementEntityBuilder();
        }

        public SettlementEntityBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public SettlementEntityBuilder transactionEntityList(List<TransactionEntity> transactionEntityList) {
            this.transactionEntityList = transactionEntityList;
            return this;
        }

        public SettlementEntityBuilder settlementDate(LocalDate settlementDate) {
            this.settlementDate = settlementDate;
            return this;
        }

        public SettlementEntityBuilder totalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public SettlementEntityBuilder settlementEnum(SettlementEnum settlementEnum) {
            this.settlementEnum = settlementEnum;
            return this;
        }

        public SettlementEntityBuilder batchId(String batchId) {
            this.batchId = batchId;
            return this;
        }

        public SettlementEntity build(){
            return new SettlementEntity(this.id, this.transactionEntityList, this.settlementDate, this.totalAmount, this.settlementEnum, this.batchId);
        }
    }
}
