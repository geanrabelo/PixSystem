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
    @JoinColumn(name = "sender_Id")
    private Account senderAccount;

    @ManyToOne
    @JoinColumn(name = "receiver_Id")
    private PixKey receiverKey;

    private BigDecimal amount;

    @Column(name = "transaction_enum")
    @Enumerated(EnumType.STRING)
    private TransactionEnum transactionEnum;

    private LocalDateTime timestamp;

    @Column(name = "end_to_end_id")
    private String endToEndId;

    private String description;

    @ManyToOne
    @JoinColumn(name = "settlement_Id")
    private Settlement settlement;
}
