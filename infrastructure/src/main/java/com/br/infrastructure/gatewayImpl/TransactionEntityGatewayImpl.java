package com.br.infrastructure.gatewayImpl;

import com.br.application.gateway.TransactionEntityGateway;
import com.br.core.entities.TransactionEntity;
import com.br.core.enums.EnumCode;
import com.br.core.exceptions.TransactionIdNotFound;
import com.br.infrastructure.domain.Transaction;
import com.br.infrastructure.dto.transaction.TransactionDatabaseToEntityDTO;
import com.br.infrastructure.dto.transaction.TransactionJpaDTO;
import com.br.infrastructure.repositories.TransactionRepository;
import com.br.usecases.PixKeyEntityUsecases;
import com.br.usecases.SettlementEntityUsecases;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

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
    public TransactionEntity findById(UUID id) {
        if(transactionRepository.existsById(id)){
            Transaction transaction = transactionRepository.getReferenceById(id);
            return new TransactionDatabaseToEntityDTO(transaction).fromJpaToEntity();
        }
        throw new TransactionIdNotFound(EnumCode.TRS0000.getMessage());
    }

    @Override
    public List<TransactionEntity> findAll() {
        return transactionRepository.findAll().stream().map(t -> new TransactionDatabaseToEntityDTO(t).fromJpaToEntity()).toList();
    }
}
