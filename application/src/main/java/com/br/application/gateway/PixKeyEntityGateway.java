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

    void active(UUID id);

    void disable(UUID id);

    List<PixKeyEntity> findAll();

    List<PixKeyEntity> findByAccount(AccountEntity accountEntity);

    PixKeyEntity findByKeyValue(String keyValue);

    PixKeyEntity findById(UUID id);

    void delete(UUID id);

}
