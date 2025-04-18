package com.br.infrastructure.dto.pixKey;

import com.br.core.entities.PixKeyEntity;
import com.br.infrastructure.domain.PixKey;
import com.br.infrastructure.dto.account.AccountDatabaseToEntityDTO;

public record PixKeyDatabaseToEntityDTO(PixKey pixKey) {

    public PixKeyEntity fromJpaForEntity(){
        return new PixKeyEntity.PixKeyBuilder()
                .builder()
                .id(pixKey.getId())
                .keyValue(pixKey.getKeyValue())
                .keyType(pixKey.getKeyType())
                .accountEntity(new AccountDatabaseToEntityDTO(pixKey.getAccount()).fromJpaForEntity())
                .createdAt(pixKey.getCreatedAt())
                .active(pixKey.getActive())
                .build();
    }
}
