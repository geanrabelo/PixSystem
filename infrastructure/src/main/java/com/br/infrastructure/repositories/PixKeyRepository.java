package com.br.infrastructure.repositories;

import com.br.core.enums.KeyType;
import com.br.infrastructure.domain.Account;
import com.br.infrastructure.domain.PixKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PixKeyRepository extends JpaRepository<PixKey, UUID> {

    boolean existsByKeyValue(String keyValue);

    boolean existsByKeyType(KeyType keyType);

    @Query("SELECT p FROM pixKey p WHERE p.account.id = :accountId")
    List<PixKey> findByAccountId(@Param("accountId") UUID accountId);

}
