package com.br.infrastructure.gatewayImpl;

import com.br.application.gateway.RefundEntityGateway;
import com.br.core.entities.RefundEntity;
import com.br.core.enums.EnumCode;
import com.br.core.enums.RefundEnum;
import com.br.core.exceptions.RefundHasAlreadyBeenProcessed;
import com.br.core.exceptions.RefundIdNotFound;
import com.br.infrastructure.domain.Refund;
import com.br.infrastructure.dto.refund.RefundDatabaseToEntityDTO;
import com.br.infrastructure.dto.refund.RefundJpaDTO;
import com.br.infrastructure.repositories.RefundRepository;
import com.br.usecases.TransactionEntityUsecases;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class RefundEntityGatewayImpl implements RefundEntityGateway {

    private final RefundRepository refundRepository;
    private final TransactionEntityUsecases transactionEntityUsecases;

    public RefundEntityGatewayImpl(RefundRepository refundRepository, TransactionEntityUsecases transactionEntityUsecases){
        this.refundRepository = refundRepository;
        this.transactionEntityUsecases = transactionEntityUsecases;
    }

    @Override
    public void requestRefund(RefundEntity refundEntity) {
        if(!isThereSomethingRefundWithTransaction(refundEntity.getTransactionEntity().getId())) {
            refundRepository.save(new RefundJpaDTO(refundEntity).toJpa());
        }else{
            throw new RefundHasAlreadyBeenProcessed(EnumCode.REF0000.getMessage());
        }
    }

    @Override
    public void processRefund(RefundEntity refundEntity) {
        Refund refundDb = refundRepository.getReferenceById(refundEntity.getId());
        if(refundDb.getRefundEnum() == RefundEnum.REQUESTED){
            refundDb.setRefundEnum(refundEntity.getRefundEnum());
            refundDb.setProcessedAt(LocalDateTime.now());
            refundRepository.save(refundDb);
        }else{
            throw new RefundHasAlreadyBeenProcessed(EnumCode.REF0000.getMessage());
        }
    }

    @Override
    public List<RefundEntity> findAll() {
        return refundRepository.findAll().stream().map(r -> new RefundDatabaseToEntityDTO(r).fromJpaToEntity()).toList();
    }

    @Override
    public RefundEntity findById(UUID id) {
        if(refundRepository.existsById(id)){
            return new RefundDatabaseToEntityDTO(refundRepository.getReferenceById(id)).fromJpaToEntity();
        }
        throw new RefundIdNotFound(EnumCode.REF0001.getMessage());
    }

    @Override
    public boolean isThereSomethingRefundWithTransaction(UUID transactionId) {
        if(refundRepository.existsByTransaction_Id(transactionId)){
            return true;
        }
        return false;
    }
}
