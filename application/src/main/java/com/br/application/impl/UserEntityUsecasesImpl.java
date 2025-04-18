package com.br.application.impl;

import com.br.application.gateway.UserEntityGateway;
import com.br.core.entities.UserEntity;
import com.br.usecases.UserEntityUsecases;

import java.util.List;
import java.util.UUID;

public class UserEntityUsecasesImpl implements UserEntityUsecases {

    private final UserEntityGateway userEntityGateway;

    public UserEntityUsecasesImpl(UserEntityGateway userEntityGateway){
        this.userEntityGateway = userEntityGateway;
    }

    @Override
    public void register(UserEntity userEntity) {
        userEntityGateway.register(userEntity);
    }

    @Override
    public boolean validateCpf(String cpf) {
        return userEntityGateway.validateCpf(cpf);
    }

    @Override
    public boolean validateEmail(String email) {
        return userEntityGateway.validateEmail(email);
    }

    @Override
    public boolean existsById(UUID id) {
        return userEntityGateway.existsById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return userEntityGateway.findAll();
    }

    @Override
    public UserEntity findById(UUID id) {
        return userEntityGateway.findById(id);
    }

    @Override
    public UserEntity update(UUID id, UserEntity newUpdateUserEntity) {
        return userEntityGateway.update(id, newUpdateUserEntity);
    }

    @Override
    public void disable(UUID id) {
        userEntityGateway.disable(id);
    }

    @Override
    public void active(UUID id) {
        userEntityGateway.active(id);
    }
}
