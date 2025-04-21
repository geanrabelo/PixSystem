package com.br.infrastructure.service;

import com.br.core.entities.AccountEntity;
import com.br.core.entities.RefundEntity;
import com.br.core.entities.TransactionEntity;
import com.br.core.enums.RefundEnum;
import com.br.infrastructure.dto.refund.RefundDetailsDTO;
import com.br.infrastructure.dto.refund.RefundJpaDTO;
import com.br.infrastructure.dto.refund.RefundProcessDTO;
import com.br.infrastructure.dto.refund.RefundRequestDTO;
import com.br.usecases.AccountEntityUsecases;
import com.br.usecases.RefundEntityUsecases;
import com.br.usecases.TransactionEntityUsecases;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class RefundService {

    private final RefundEntityUsecases refundEntityUsecases;
    private final TransactionEntityUsecases transactionEntityUsecases;
    private final AccountEntityUsecases accountEntityUsecases;

    public RefundService(RefundEntityUsecases refundEntityUsecases, TransactionEntityUsecases transactionEntityUsecases, AccountEntityUsecases accountEntityUsecases){
        this.refundEntityUsecases = refundEntityUsecases;
        this.transactionEntityUsecases = transactionEntityUsecases;
        this.accountEntityUsecases = accountEntityUsecases;
    }

    public void requestRefund(RefundRequestDTO refundRequestDTO){
        TransactionEntity transactionEntity = transactionEntityUsecases.findById(refundRequestDTO.transactionId());
        refundEntityUsecases.requestRefund(new RefundEntity.RefundEntityBuilder()
                .builder()
                        .transactionEntity(transactionEntity)
                        .amount(transactionEntity.getAmount())
                        .reason(refundRequestDTO.reason())
                        .refundEnum(RefundEnum.REQUESTED)
                        .createdAt(LocalDateTime.now())
                        .processedAt(null)
                .build());
    }

    public void processedRefund(UUID id, RefundProcessDTO refundProcessDTO){
        RefundEntity refundEntityDB = refundEntityUsecases.findById(id);
        refundEntityUsecases.processRefund(new RefundEntity.RefundEntityBuilder()
                .builder()
                        .id(id)
                        .refundEnum(refundProcessDTO.refundEnum())
                .build()
        );
        if(refundProcessDTO.refundEnum() == RefundEnum.APPROVED){
            TransactionEntity transactionEntity = transactionEntityUsecases.findById(refundEntityDB.getTransactionEntity().getId());
            AccountEntity senderAccountEntity = transactionEntity.getSenderAccount();
            AccountEntity receiverAccountEntity = transactionEntity.getReceiverKey().getAccountEntity();
            accountEntityUsecases.saveData(senderAccountEntity.getId(), senderAccountEntity.getBalance().add(transactionEntity.getAmount()));
            accountEntityUsecases.saveData(receiverAccountEntity.getId(), receiverAccountEntity.getBalance().subtract(transactionEntity.getAmount()));
        }
    }


    public List<RefundDetailsDTO> findAll(){
        return refundEntityUsecases.findAll().stream().map(RefundDetailsDTO::new).toList();
    }

    public RefundDetailsDTO findById(UUID id){
        return new RefundDetailsDTO(refundEntityUsecases.findById(id));
    }

}
