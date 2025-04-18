package com.br.infrastructure.dto.account;

import com.br.core.enums.AccountType;

import java.math.BigDecimal;

public record AccountRegisterDTO(String userId,
                                 String agency,
                                 BigDecimal balance,
                                 AccountType accountType) {
}
