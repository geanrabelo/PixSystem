package com.br.infrastructure.dto.pixKey;

import com.br.core.entities.PixKeyEntity;
import com.br.infrastructure.domain.PixKey;
import com.br.infrastructure.dto.account.AccountJpaDTO;

public record PixKeyJpaDTO(PixKeyEntity pixKeyEntity) {

    public PixKey toPixKey(){
        return PixKey.builder()
                .id(pixKeyEntity.getId())
                .keyValue(pixKeyEntity.getKeyValue())
                .keyType(pixKeyEntity.getKeyType())
                .account(new AccountJpaDTO(pixKeyEntity.getAccountEntity()).toAccount())
                .createdAt(pixKeyEntity.getCreatedAt())
                .active(pixKeyEntity.getActive())
                .build();

    }
}
