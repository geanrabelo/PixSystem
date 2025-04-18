package com.br.application.gateway;

import com.br.core.entities.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserEntityGateway {

    void register(UserEntity userEntity);

    boolean validateCpf(String cpf);

    boolean validateEmail(String email);

    boolean existsById(UUID id);

    List<UserEntity> findAll();

    UserEntity findById(UUID id);

    UserEntity update(UUID id, UserEntity newUpdateUserEntity);

    void disable(UUID id);

    void active(UUID id);
}
