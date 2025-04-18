package com.br.infrastructure.gatewayImpl;

import com.br.application.gateway.AccountEntityGateway;
import com.br.core.entities.AccountEntity;
import com.br.core.enums.EnumCode;
import com.br.core.exceptions.AccountIdNotFound;
import com.br.core.exceptions.AccountNumberAlreadyExists;
import com.br.infrastructure.domain.Account;
import com.br.infrastructure.dto.account.AccountDatabaseToEntityDTO;
import com.br.infrastructure.dto.account.AccountJpaDTO;
import com.br.infrastructure.repositories.AccountRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Component
public class AccountEntityGatewayImpl implements AccountEntityGateway {

    private final AccountRepository accountRepository;

    public AccountEntityGatewayImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public void register(AccountEntity accountEntity) {
        if(!accountRepository.existsByAccountNumber(accountEntity.getAccountNumber())){
            accountRepository.save(new AccountJpaDTO(accountEntity).toAccount());
        }else {
            throw new AccountNumberAlreadyExists(EnumCode.ACC0001.getMessage());
        }
    }

    @Override
    public void saveData(UUID id, BigDecimal balance) {
        if(existsById(id)){
            Account account = accountRepository.getReferenceById(id);
            account.setBalance(balance);
            accountRepository.save(account);
        }else{
            throw new AccountIdNotFound(EnumCode.ACC0001.getMessage());
        }
    }


    @Override
    public List<AccountEntity> findAll() {
        return accountRepository.findAll().stream().map(a -> new AccountDatabaseToEntityDTO(a).fromJpaForEntity()).toList();
    }

    @Override
    public AccountEntity findById(UUID id) {
        if(existsById(id)){
            Account account = accountRepository.getReferenceById(id);
            return new AccountDatabaseToEntityDTO(account).fromJpaForEntity();
        }
        throw new AccountIdNotFound(EnumCode.ACC0000.getMessage());
    }

    @Override
    public boolean existsById(UUID id) {
        return accountRepository.existsById(id);
    }

    @Override
    public void delete(UUID id) {
        if(existsById(id)){
            accountRepository.deleteById(id);
        }else{
            throw new AccountIdNotFound(EnumCode.ACC0000.getMessage());
        }
    }
}
