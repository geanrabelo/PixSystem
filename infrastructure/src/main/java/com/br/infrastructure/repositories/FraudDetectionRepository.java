package com.br.infrastructure.repositories;

import com.br.infrastructure.domain.FraudDetection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FraudDetectionRepository extends JpaRepository<FraudDetection, UUID> {
}
