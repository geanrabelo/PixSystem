package com.br.infrastructure.service;

import com.br.core.entities.AccountEntity;
import com.br.core.entities.PixKeyEntity;
import com.br.core.entities.SettlementEntity;
import com.br.core.entities.TransactionEntity;
import com.br.core.enums.EnumCode;
import com.br.core.exceptions.AccountNotHaveBalanceEnough;
import com.br.core.exceptions.PixKeyReceiverNotFound;
import com.br.infrastructure.dto.transaction.TransactionDataDetailsDTO;
import com.br.infrastructure.dto.transaction.TransactionDatabaseToEntityDTO;
import com.br.infrastructure.dto.transaction.TransactionRegisterDTO;
import com.br.usecases.AccountEntityUsecases;
import com.br.usecases.PixKeyEntityUsecases;
import com.br.usecases.SettlementEntityUsecases;
import com.br.usecases.TransactionEntityUsecases;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionEntityUsecases transactionEntityUsecases;
    private final AccountEntityUsecases accountEntityUsecases;
    private final PixKeyEntityUsecases pixKeyEntityUsecases;
    private final SettlementEntityUsecases settlementEntityUsecases;

    public TransactionService(TransactionEntityUsecases transactionEntityUsecases,
                              AccountEntityUsecases accountEntityUsecases,
                              PixKeyEntityUsecases pixKeyEntityUsecases,
                              SettlementEntityUsecases settlementEntityUsecases){
        this.transactionEntityUsecases = transactionEntityUsecases;
        this.accountEntityUsecases = accountEntityUsecases;
        this.pixKeyEntityUsecases = pixKeyEntityUsecases;
        this.settlementEntityUsecases = settlementEntityUsecases;
    }

    public String sendPix(TransactionRegisterDTO transactionRegisterDTO){
        AccountEntity accountEntity = accountEntityUsecases.findById(UUID.fromString(transactionRegisterDTO.senderAccountId()));
        PixKeyEntity pixKeyEntity = pixKeyEntityUsecases.findByKeyValue(transactionRegisterDTO.receiverKey());
        SettlementEntity settlementEntity = settlementEntityUsecases.findById(UUID.fromString(transactionRegisterDTO.settlementId()));
        if(!pixKeyEntityUsecases.validateKeyValue(transactionRegisterDTO.receiverKey())
                &&
                verificationBalanceSuficient(accountEntity.getBalance(), transactionRegisterDTO.amount())){
            transactionEntityUsecases.sendPix(new TransactionEntity.TransactionEntityBuilder()
                    .builder()
                            .senderAccount(accountEntity)
                            .receiverKey(pixKeyEntity)
                            .amount(transactionRegisterDTO.amount())
                            .description(transactionRegisterDTO.description())
                            .settlementEntity(settlementEntity)
                    .build());
            BigDecimal newBalanceSender = accountEntity.getBalance().subtract(transactionRegisterDTO.amount());
            BigDecimal newBalanceReceiver = pixKeyEntity.getAccountEntity().getBalance().add(transactionRegisterDTO.amount());
            accountEntityUsecases.saveData(accountEntity.getId(), newBalanceSender);
            accountEntityUsecases.saveData(pixKeyEntity.getAccountEntity().getId(), newBalanceReceiver);
            settlementEntityUsecases.updateAmount(transactionRegisterDTO.amount(), UUID.fromString(transactionRegisterDTO.settlementId()));
            return "PixKey Registered successfully";
        } else if (!verificationBalanceSuficient(accountEntity.getBalance(), transactionRegisterDTO.amount())) {
            throw new AccountNotHaveBalanceEnough(EnumCode.ACC0002.getMessage());
        }
        throw new PixKeyReceiverNotFound(EnumCode.PXK0002.getMessage());
    }

    public TransactionDataDetailsDTO findById(UUID id){
        return new TransactionDataDetailsDTO(transactionEntityUsecases.findById(id));
    }

    public List<TransactionDataDetailsDTO> findAll(){
        return transactionEntityUsecases.findAll().stream().map(TransactionDataDetailsDTO::new).toList();
    }

    private boolean verificationBalanceSuficient(BigDecimal balance, BigDecimal amount){
        if(balance.compareTo(amount) >= 0){
            return true;
        }
        return false;
    }
}
