package com.br.usecases;

import com.br.core.entities.RefundEntity;

import java.util.List;
import java.util.UUID;

public interface RefundEntityUsecases {

    void requestRefund(RefundEntity refundEntity);

    void processRefund(RefundEntity refundEntity);

    boolean isThereSomethingRefundWithTransaction(UUID transactionId);

    List<RefundEntity> findAll();

    RefundEntity findById(UUID id);
}
