package com.br.core.entities;

import com.br.core.enums.AccountType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class AccountEntity {

    public AccountEntity(UserEntity userEntity, String accountNumber, String agency, BigDecimal balance, AccountType accountType){
        this.id = UUID.randomUUID();
        this.userEntity = userEntity;
        this.accountNumber = accountNumber;
        this.agency = agency;
        this.balance = balance;
        this.accountType = accountType;
        this.createdAt = LocalDateTime.now();
    }

    public AccountEntity(UUID id, UserEntity userEntity, String accountNumber, String agency, BigDecimal balance, AccountType accountType, LocalDateTime createdAt, List<PixKeyEntity> pixKeyEntityList, List<TransactionEntity> transactionEntityList) {
        this.id = id;
        this.userEntity = userEntity;
        this.accountNumber = accountNumber;
        this.agency = agency;
        this.balance = balance;
        this.accountType = accountType;
        this.createdAt = createdAt;
        this.pixKeyEntityList = pixKeyEntityList;
        this.transactionEntityList = transactionEntityList;
    }

    private UUID id;
    private UserEntity userEntity;
    private String accountNumber; // unique
    private String agency;
    private BigDecimal balance;
    private AccountType accountType;
    private LocalDateTime createdAt;
    private List<PixKeyEntity> pixKeyEntityList;
    private List<TransactionEntity> transactionEntityList;

    public List<PixKeyEntity> getPixKeyEntityList() {
        return pixKeyEntityList;
    }

    public void setPixKeyEntityList(List<PixKeyEntity> pixKeyEntityList) {
        this.pixKeyEntityList = pixKeyEntityList;
    }

    public List<TransactionEntity> getTransactionEntityList() {
        return transactionEntityList;
    }

    public void setTransactionEntityList(List<TransactionEntity> transactionEntityList) {
        this.transactionEntityList = transactionEntityList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static class AccountEntityBuilder{
        private UUID id;
        private UserEntity userEntity;
        private String accountNumber; // unique
        private String agency;
        private BigDecimal balance;
        private AccountType accountType;
        private LocalDateTime createdAt;
        private List<PixKeyEntity> pixKeyEntityList;
        private List<TransactionEntity> transactionEntityList;


        public AccountEntityBuilder builder(){
            return new AccountEntityBuilder();
        }

        public AccountEntityBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public AccountEntityBuilder userEntity(UserEntity userEntity) {
            this.userEntity = userEntity;
            return this;
        }

        public AccountEntityBuilder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public AccountEntityBuilder agency(String agency) {
            this.agency = agency;
            return this;
        }

        public AccountEntityBuilder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public AccountEntityBuilder accountType(AccountType accountType) {
            this.accountType = accountType;
            return this;
        }

        public AccountEntityBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccountEntityBuilder pixKeyEntityList(List<PixKeyEntity> pixKeyEntityList){
            this.pixKeyEntityList = pixKeyEntityList;
            return this;
        }

        public AccountEntityBuilder transactionEntityList(List<TransactionEntity> transactionEntityList){
            this.transactionEntityList = transactionEntityList;
            return this;
        }

        public AccountEntity build(){
            return new AccountEntity(this.id, this.userEntity, this.accountNumber, this.agency, this.balance, this.accountType, this.createdAt, this.pixKeyEntityList, this.transactionEntityList);
        }
    }
}
