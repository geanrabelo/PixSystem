package com.br.infrastructure.repositories;

import com.br.infrastructure.domain.Refund;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RefundRepository extends JpaRepository<Refund, UUID> {

    boolean existsByTransaction_Id(UUID transactionId);
}
