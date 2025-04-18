package com.br.usecases;

import com.br.core.entities.AccountEntity;

import java.util.List;
import java.util.UUID;

public interface AccountEntityUsecases {

    void register(AccountEntity accountEntity);

    List<AccountEntity> findAll();

    AccountEntity findById(UUID id);

    boolean existsById(UUID id);

    void delete(UUID id);
}
