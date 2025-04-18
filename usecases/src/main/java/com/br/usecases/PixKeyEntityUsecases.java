package com.br.usecases;

import com.br.core.entities.AccountEntity;
import com.br.core.entities.PixKeyEntity;
import com.br.core.enums.KeyType;

import java.util.List;
import java.util.UUID;

public interface PixKeyEntityUsecases {

    void register(PixKeyEntity pixKeyEntity);

    boolean validateKeyValue(String keyValue);

    boolean existsById(UUID id);

    boolean existsTransactions();

    List<PixKeyEntity> findAll();

    List<PixKeyEntity> findByAccount(AccountEntity accountEntity);

    PixKeyEntity findById(UUID id);

    PixKeyEntity findByKeyValue(String keyValue);

    void delete(UUID id);
}
