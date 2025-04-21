package com.br.infrastructure.dto.refund;

import java.math.BigDecimal;
import java.util.UUID;

public record RefundRequestDTO(UUID transactionId, String reason) {

}
