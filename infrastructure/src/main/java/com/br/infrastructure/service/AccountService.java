package com.br.infrastructure.service;

import com.br.core.entities.AccountEntity;
import com.br.core.entities.UserEntity;
import com.br.infrastructure.dto.account.AccountDetailsDTO;
import com.br.infrastructure.dto.account.AccountRegisterDTO;
import com.br.usecases.AccountEntityUsecases;
import com.br.usecases.UserEntityUsecases;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountEntityUsecases accountEntityUsecases;
    private final UserEntityUsecases userEntityUsecases;


    public AccountService(AccountEntityUsecases accountEntityUsecases, UserEntityUsecases userEntityUsecases){
        this.accountEntityUsecases = accountEntityUsecases;
        this.userEntityUsecases = userEntityUsecases;
    }

    public String register(AccountRegisterDTO accountRegisterDTO){
        UserEntity userEntity = userEntityUsecases.findById(UUID.fromString(accountRegisterDTO.userId()));
        accountEntityUsecases.register(new AccountEntity.AccountEntityBuilder()
                .builder()
                .userEntity(userEntity)
                .accountNumber(UUID.randomUUID().toString())
                .agency(accountRegisterDTO.agency())
                .balance(accountRegisterDTO.balance())
                .accountType(accountRegisterDTO.accountType())
                .createdAt(LocalDateTime.now())
                .build());
        return "Account Registered successfully";
    }

    public List<AccountDetailsDTO> findAll(){
        return accountEntityUsecases.findAll().stream().map(AccountDetailsDTO::new).toList();
    }

    public AccountDetailsDTO findById(UUID id){
        return new AccountDetailsDTO(accountEntityUsecases.findById(id));
    }

    public void deleteById(UUID id){
        accountEntityUsecases.delete(id);
    }
}
