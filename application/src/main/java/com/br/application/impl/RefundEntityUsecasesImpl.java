package com.br.application.impl;

import com.br.application.gateway.RefundEntityGateway;
import com.br.core.entities.RefundEntity;
import com.br.usecases.RefundEntityUsecases;

public class RefundEntityUsecasesImpl implements RefundEntityUsecases {

    private final RefundEntityGateway refundEntityGateway;

    public RefundEntityUsecasesImpl(RefundEntityGateway refundEntityGateway){
        this.refundEntityGateway = refundEntityGateway;
    }

    @Override
    public void requestRefund(RefundEntity refundEntity) {
        refundEntityGateway.requestRefund(refundEntity);
    }

    @Override
    public void processRefund(RefundEntity refundEntity) {
        refundEntityGateway.processRefund(refundEntity);
    }
}
