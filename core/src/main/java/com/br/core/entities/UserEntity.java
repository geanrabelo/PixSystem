package com.br.core.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class UserEntity {

    public UserEntity(String name, String cpf, String emails, String phone){
        this.name = name;
        this.cpf = cpf;
        this.emails = emails;
        this.phone = phone;
        this.createdAt = LocalDateTime.now();
        this.active = true;
    }

    public UserEntity(UUID id, String name, String cpf, String emails, String phone, LocalDateTime createdAt, Boolean active, List<AccountEntity> accountEntityList) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.emails = emails;
        this.phone = phone;
        this.createdAt = createdAt;
        this.active = active;
        this.accountEntityList = accountEntityList;
    }

    private UUID id;
    private String name;
    private String cpf; // unique
    private String emails; // unique
    private String phone;
    private LocalDateTime createdAt;
    private Boolean active;
    private List<AccountEntity> accountEntityList;

    public List<AccountEntity> getAccountEntityList() {
        return accountEntityList;
    }

    public void setAccountEntityList(List<AccountEntity> accountEntityList) {
        this.accountEntityList = accountEntityList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    public static class UserEntityBuilder{
        private UUID id;
        private String name;
        private String cpf; // unique
        private String emails; // unique
        private String phone;
        private LocalDateTime createdAt;
        private Boolean active;
        private List<AccountEntity> accountEntityList;


        public UserEntityBuilder builder(){
            return new UserEntityBuilder();
        }

        public UserEntityBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public UserEntityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserEntityBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public UserEntityBuilder emails(String emails) {
            this.emails = emails;
            return this;
        }

        public UserEntityBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserEntityBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public UserEntityBuilder active(Boolean active) {
            this.active = active;
            return this;
        }

        public UserEntityBuilder accountEntityList(List<AccountEntity> accountEntityList){
            this.accountEntityList = accountEntityList;
            return this;
        }

        public UserEntity build(){
            return new UserEntity(this.id, this.name, this.cpf, this.emails, this.phone, this.createdAt, this.active, this.accountEntityList);
        }
    }
}
