package com.br.usecases;

import com.br.core.entities.RefundEntity;

public interface RefundEntityUsecases {

    void requestRefund(RefundEntity refundEntity);

    void processRefund(RefundEntity refundEntity);

}
