package com.br.infrastructure.gatewayImpl;

import com.br.application.gateway.TransactionEntityGateway;
import com.br.core.entities.TransactionEntity;
import com.br.infrastructure.dto.transaction.TransactionJpaDTO;
import com.br.infrastructure.repositories.TransactionRepository;
import com.br.usecases.AccountEntityUsecases;
import com.br.usecases.PixKeyEntityUsecases;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TransactionEntityGatewayImpl implements TransactionEntityGateway {

    private final TransactionRepository transactionRepository;
    private final PixKeyEntityUsecases pixKeyEntityUsecases;

    public TransactionEntityGatewayImpl(TransactionRepository transactionRepository, PixKeyEntityUsecases pixKeyEntityUsecases){
        this.transactionRepository = transactionRepository;
        this.pixKeyEntityUsecases = pixKeyEntityUsecases;
    }

    @Override
    public void sendPix(TransactionEntity transactionEntity) {
        if(validateKey(transactionEntity.getReceiverKey().getKeyValue())){
            transactionRepository.save(new TransactionJpaDTO(transactionEntity).toTransactionJpa());
        }
    }

    @Override
    public boolean validateAmount(BigDecimal amount) {
        return false;
    }

    @Override
    public boolean validateKey(String key) {
        return !pixKeyEntityUsecases.validateKeyValue(key);
    }

    @Override
    public void processReceivePix(TransactionEntity transactionEntity) {

    }
}
