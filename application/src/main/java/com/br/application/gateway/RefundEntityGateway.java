package com.br.application.gateway;

import com.br.core.entities.RefundEntity;

public interface RefundEntityGateway {

    void requestRefund(RefundEntity refundEntity);

    void processRefund(RefundEntity refundEntity);
}
