package com.br.infrastructure.domain;

import com.br.core.enums.FraudDetectionEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_fraud")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class FraudDetection {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    private Transaction transaction;

    private Double riskScore;

    private List<String> indicators;

    @Enumerated(EnumType.STRING)
    private FraudDetectionEnum fraudDetectionEnum;

    private Boolean reviewed;

    private String reviewNotes;
}
