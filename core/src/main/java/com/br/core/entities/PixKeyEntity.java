package com.br.core.entities;

import com.br.core.enums.KeyType;

import java.time.LocalDateTime;
import java.util.UUID;

public class PixKeyEntity {

    public PixKeyEntity(UUID id, String keyValue, KeyType keyType, AccountEntity accountEntity, LocalDateTime createdAt, Boolean active) {
        this.id = id;
        this.keyValue = keyValue;
        this.keyType = keyType;
        this.accountEntity = accountEntity;
        this.createdAt = createdAt;
        this.active = active;
    }

    private UUID id;
    private String keyValue; // unique
    private KeyType keyType;
    private AccountEntity accountEntity;
    private LocalDateTime createdAt;
    private Boolean active;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public KeyType getKeyType() {
        return keyType;
    }

    public void setKeyType(KeyType keyType) {
        this.keyType = keyType;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    public static class PixKeyBuilder{
        private UUID id;
        private String keyValue; // unique
        private KeyType keyType;
        private AccountEntity accountEntity;
        private LocalDateTime createdAt;
        private Boolean active;

        public PixKeyBuilder builder(){
            return new PixKeyBuilder();
        }

        public PixKeyBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PixKeyBuilder accountEntity(AccountEntity accountEntity) {
            this.accountEntity = accountEntity;
            return this;
        }

        public PixKeyBuilder keyType(KeyType keyType) {
            this.keyType = keyType;
            return this;
        }

        public PixKeyBuilder keyValue(String keyValue) {
            this.keyValue = keyValue;
            return this;
        }

        public PixKeyBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public PixKeyBuilder active(Boolean active) {
            this.active = active;
            return this;
        }

        public PixKeyEntity build(){
            return new PixKeyEntity(this.id,
                    this.keyValue,
                    this.keyType,
                    this.accountEntity,
                    this.createdAt,
                    this.active);
        }
    }
}
