package com.br.infrastructure.service;

import com.br.core.entities.AccountEntity;
import com.br.core.entities.PixKeyEntity;
import com.br.core.enums.EnumCode;
import com.br.core.exceptions.PixKeyReceiverNotFound;
import com.br.infrastructure.dto.transaction.TransactionRegisterDTO;
import com.br.usecases.AccountEntityUsecases;
import com.br.usecases.PixKeyEntityUsecases;
import com.br.usecases.TransactionEntityUsecases;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionEntityUsecases transactionEntityUsecases;
    private final AccountEntityUsecases accountEntityUsecases;
    private final PixKeyEntityUsecases pixKeyEntityUsecases;

    public TransactionService(TransactionEntityUsecases transactionEntityUsecases, AccountEntityUsecases accountEntityUsecases, PixKeyEntityUsecases pixKeyEntityUsecases){
        this.transactionEntityUsecases = transactionEntityUsecases;
        this.accountEntityUsecases = accountEntityUsecases;
        this.pixKeyEntityUsecases = pixKeyEntityUsecases;
    }

    public String sendPix(TransactionRegisterDTO transactionRegisterDTO){
        AccountEntity accountEntity = accountEntityUsecases.findById(UUID.fromString(transactionRegisterDTO.senderAccountId()));
        if(!pixKeyEntityUsecases.validateKeyValue(transactionRegisterDTO.receiverKey())){

            return "PixKey Registered successfully";
        }
        throw new PixKeyReceiverNotFound(EnumCode.PXK0002.getMessage());
    }
}
