package com.br.infrastructure.dto.pixKey;

import com.br.core.enums.KeyType;

public record PixKeyRegisterDTO(String keyValue,
                                KeyType keyType,
                                String accountId) {
}
