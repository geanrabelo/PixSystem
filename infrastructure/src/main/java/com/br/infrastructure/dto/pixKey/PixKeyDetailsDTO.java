package com.br.infrastructure.dto.pixKey;

import com.br.core.entities.PixKeyEntity;
import com.br.core.enums.KeyType;
import com.br.infrastructure.domain.Account;
import com.br.infrastructure.dto.account.AccountDetailsDTO;
import com.br.infrastructure.dto.account.AccountJpaDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record PixKeyDetailsDTO(UUID id,
                               String keyValue,
                               KeyType keyType,
                               AccountDetailsDTO account,
                               LocalDateTime createdAt,
                               Boolean active) {
    public PixKeyDetailsDTO (PixKeyEntity pixKeyEntity){
        this(pixKeyEntity.getId(),
                pixKeyEntity.getKeyValue(),
                pixKeyEntity.getKeyType(),
                new AccountDetailsDTO(pixKeyEntity.getAccountEntity()),
                pixKeyEntity.getCreatedAt(),
                pixKeyEntity.getActive()
                );
    }
}
