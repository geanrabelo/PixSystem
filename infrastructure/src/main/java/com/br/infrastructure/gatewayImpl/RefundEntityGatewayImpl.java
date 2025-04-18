package com.br.infrastructure.gatewayImpl;

import com.br.application.gateway.RefundEntityGateway;
import com.br.core.entities.RefundEntity;
import com.br.infrastructure.repositories.RefundRepository;
import org.springframework.stereotype.Component;

@Component
public class RefundEntityGatewayImpl implements RefundEntityGateway {

    private final RefundRepository refundRepository;

    public RefundEntityGatewayImpl(RefundRepository refundRepository){
        this.refundRepository = refundRepository;
    }

    @Override
    public void requestRefund(RefundEntity refundEntity) {

    }

    @Override
    public void processRefund(RefundEntity refundEntity) {

    }
}
