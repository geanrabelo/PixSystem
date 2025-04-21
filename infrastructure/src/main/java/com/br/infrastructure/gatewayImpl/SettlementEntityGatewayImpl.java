package com.br.infrastructure.gatewayImpl;

import com.br.application.gateway.SettlementEntityGateway;
import com.br.core.entities.SettlementEntity;
import com.br.core.enums.EnumCode;
import com.br.core.exceptions.SettlementIdNotFound;
import com.br.infrastructure.domain.Settlement;
import com.br.infrastructure.domain.Transaction;
import com.br.infrastructure.dto.settlement.SettlementDatabaseToEntityDTO;
import com.br.infrastructure.dto.settlement.SettlementJpaDTO;
import com.br.infrastructure.dto.transaction.TransactionDatabaseToEntityDTO;
import com.br.infrastructure.repositories.SettlementRepository;
import com.br.infrastructure.repositories.TransactionRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Component
public class SettlementEntityGatewayImpl implements SettlementEntityGateway {

    private final SettlementRepository settlementRepository;
    private final TransactionRepository transactionRepository;

    public SettlementEntityGatewayImpl(SettlementRepository settlementRepository, TransactionRepository transactionRepository){
        this.settlementRepository = settlementRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void generateSettlementBatch(SettlementEntity settlementEntity) {
        List<Transaction> transactionList = transactionRepository.findAllByDate(settlementEntity.getSettlementDate());
        settlementEntity.setTransactionEntityList(transactionList.stream()
                .map(t -> new TransactionDatabaseToEntityDTO(t)
                        .fromJpaToEntity())
                .toList());
        settlementRepository.save(new SettlementJpaDTO(settlementEntity).toSettlementJpa());
    }

    @Override
    public SettlementEntity findById(UUID id) {
        if(settlementRepository.existsById(id)){
            return new SettlementDatabaseToEntityDTO(settlementRepository.getReferenceById(id)).toEntity();
        }
        throw new SettlementIdNotFound(EnumCode.SLT0000.getMessage());
    }

    @Override
    public List<SettlementEntity> findAll() {
        return settlementRepository.findAll().stream().map(s -> new SettlementDatabaseToEntityDTO(s).toEntity()).toList();
    }

    @Override
    public void updateAmount(BigDecimal value, UUID id) {
         if(settlementRepository.existsById(id)) {
             Settlement settlement = settlementRepository.getReferenceById(id);
             if (settlement.getTotalAmount() == null) {
                 settlement.setTotalAmount(value);
             } else {
                 settlement.setTotalAmount(settlement.getTotalAmount().add(value));
             }
             settlementRepository.save(settlement);
         }else {
             throw new SettlementIdNotFound(EnumCode.SLT0000.getMessage());
         }
    }
}
