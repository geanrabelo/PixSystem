package com.br.infrastructure.dto.account;

import com.br.core.entities.AccountEntity;
import com.br.core.enums.AccountType;
import com.br.infrastructure.dto.pixKey.PixKeyDetailsDTO;
import com.br.infrastructure.dto.transaction.TransactionDetailsIDDTO;
import com.br.infrastructure.dto.user.UserDetailsDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record AccountDetailsDTO(UUID id, UserDetailsDTO user, String accountNumber, String agency, BigDecimal balance, AccountType accountType, LocalDateTime createdAt, List<PixKeyDetailsDTO> pixKeyList, List<TransactionDetailsIDDTO> transactionIdList) {

    public AccountDetailsDTO(AccountEntity accountEntity){
        this(accountEntity.getId(),
                new UserDetailsDTO(accountEntity.getUserEntity()),
                accountEntity.getAccountNumber(),
                accountEntity.getAgency(),
                accountEntity.getBalance(),
                accountEntity.getAccountType(),
                accountEntity.getCreatedAt(),
                accountEntity.getPixKeyEntityList().stream().map(p ->
                                new PixKeyDetailsDTO(p.getId(), p.getKeyValue(), p.getKeyType(), accountEntity.getId(), p.getCreatedAt(), p.getActive())
                ).toList(),
                accountEntity.getTransactionEntityList().stream().map(t -> new TransactionDetailsIDDTO(t.getId())).toList());
    }
}
