package com.br.application.gateway;

import com.br.core.entities.RefundEntity;

import java.util.List;
import java.util.UUID;

public interface RefundEntityGateway {

    void requestRefund(RefundEntity refundEntity);

    void processRefund(RefundEntity refundEntity);

    List<RefundEntity> findAll();

    RefundEntity findById(UUID id);

    boolean isThereSomethingRefundWithTransaction(UUID transactionId);
}
