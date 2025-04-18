package com.br.infrastructure.domain;

import com.br.core.enums.SettlementEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_settlement")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "settlement")
    private List<Transaction> transactionList;

    private LocalDate settlementDate;

    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private SettlementEnum settlementEnum;

    private String batchId;

}
