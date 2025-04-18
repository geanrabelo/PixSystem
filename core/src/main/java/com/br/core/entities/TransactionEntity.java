package com.br.core.entities;

import com.br.core.enums.TransactionEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionEntity {

    public TransactionEntity(AccountEntity accountEntity, PixKeyEntity receiverKey, BigDecimal amount, String description){
        this.id = UUID.randomUUID();
        this.senderAccount = accountEntity;
        this.receiverKey = receiverKey;
        this.amount = amount;
        this.transactionEnum = null;
        this.timestamp = LocalDateTime.now();
        this.endToEndId = UUID.randomUUID().toString();
        this.description = description;
    }

    public TransactionEntity(UUID id, AccountEntity senderAccount, PixKeyEntity receiverKey, BigDecimal amount, TransactionEnum transactionEnum, LocalDateTime timestamp, String endToEndId, String description, SettlementEntity settlementEntity) {
        this.id = id;
        this.senderAccount = senderAccount;
        this.receiverKey = receiverKey;
        this.amount = amount;
        this.transactionEnum = transactionEnum;
        this.timestamp = timestamp;
        this.endToEndId = endToEndId;
        this.description = description;
        this.settlementEntity = settlementEntity;
    }

    private UUID id;
    private AccountEntity senderAccount;
    private PixKeyEntity receiverKey;
    private BigDecimal amount;
    private TransactionEnum transactionEnum;
    private LocalDateTime timestamp;
    private String endToEndId;
    private String description;
    private SettlementEntity settlementEntity;

    public SettlementEntity getSettlementEntity() {
        return settlementEntity;
    }

    public void setSettlementEntity(SettlementEntity settlementEntity) {
        this.settlementEntity = settlementEntity;
    }

    public String getDescription() {
        return description;
    }

    public TransactionEnum getTransactionEnum() {
        return transactionEnum;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndToEndId() {
        return endToEndId;
    }

    public void setEndToEndId(String endToEndId) {
        this.endToEndId = endToEndId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public TransactionEnum getStatus() {
        return transactionEnum;
    }

    public void setTransactionEnum(TransactionEnum transactionEnum) {
        this.transactionEnum = transactionEnum;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PixKeyEntity getReceiverKey() {
        return receiverKey;
    }

    public void setReceiverKey(PixKeyEntity receiverKey) {
        this.receiverKey = receiverKey;
    }

    public AccountEntity getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(AccountEntity senderAccount) {
        this.senderAccount = senderAccount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    public static class TransactionEntityBuilder{
        private UUID id;
        private AccountEntity senderAccount;
        private PixKeyEntity receiverKey;
        private BigDecimal amount;
        private TransactionEnum transactionEnum;
        private LocalDateTime timestamp;
        private String endToEndId;
        private String description;
        private SettlementEntity settlementEntity;

        public TransactionEntityBuilder builder(){
            return new TransactionEntityBuilder();
        }

        public TransactionEntityBuilder description(String description) {
            this.description = description;
            return this;
        }

        public TransactionEntityBuilder endToEndId(String endToEndId) {
            this.endToEndId = endToEndId;
            return this;
        }
        public TransactionEntityBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }
        public TransactionEntityBuilder transactionEnum(TransactionEnum transactionEnum) {
            this.transactionEnum = transactionEnum;
            return this;
        }

        public TransactionEntityBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public TransactionEntityBuilder receiverKey(PixKeyEntity receiverKey) {
            this.receiverKey = receiverKey;
            return this;
        }

        public TransactionEntityBuilder senderAccount(AccountEntity senderAccount) {
            this.senderAccount = senderAccount;
            return this;
        }

        public TransactionEntityBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public TransactionEntityBuilder settlementEntity(SettlementEntity settlementEntity){
            this.settlementEntity = settlementEntity;
            return this;
        }

        public TransactionEntity build(){
            return new TransactionEntity(this.id, this.senderAccount, this.receiverKey, this.amount, this. transactionEnum, this.timestamp, this.endToEndId, this.description, this.settlementEntity);
        }
    }
}
