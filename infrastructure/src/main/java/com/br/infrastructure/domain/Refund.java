package com.br.infrastructure.domain;

import com.br.core.enums.RefundEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_refund")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transactionId")
    private Transaction transaction;

    private BigDecimal amount;

    private String reason;

    @Enumerated(EnumType.STRING)
    private RefundEnum refundEnum;

    private LocalDateTime createdAt;

    private LocalDateTime processedAt;
}
