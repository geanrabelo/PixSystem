package com.br.infrastructure.domain;

import com.br.core.enums.TransactionEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_transaction")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "senderId")
    private Account senderAccount;

    @ManyToOne
    @JoinColumn(name = "receiverId")
    private PixKey receiverKey;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionEnum transactionEnum;

    private LocalDateTime timestamp;

    private String endToEndId;

    private String description;

    @ManyToOne
    @JoinColumn(name = "settlementId")
    private Settlement settlement;
}
