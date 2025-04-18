package com.br.application.gateway;

import com.br.core.entities.AccountEntity;
import com.br.core.entities.PixKeyEntity;
import com.br.core.enums.KeyType;

import java.util.List;
import java.util.UUID;

public interface PixKeyEntityGateway {

    void register(PixKeyEntity pixKeyEntity);

    boolean validateKeyValue(String keyValue);

    boolean existsById(UUID id);

    boolean existsTransactions();

    List<PixKeyEntity> findAll();

    List<PixKeyEntity> findByAccount(AccountEntity accountEntity);

    PixKeyEntity findById(UUID id);

    void delete(UUID id);

}
