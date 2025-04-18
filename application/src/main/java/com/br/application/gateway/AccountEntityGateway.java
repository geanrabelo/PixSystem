package com.br.application.gateway;

import com.br.core.entities.AccountEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface AccountEntityGateway {

    void register(AccountEntity accountEntity);

    void saveData(UUID id, BigDecimal balance);

    List<AccountEntity> findAll();

    AccountEntity findById(UUID id);

    boolean existsById(UUID id);

    void delete(UUID id);

}
