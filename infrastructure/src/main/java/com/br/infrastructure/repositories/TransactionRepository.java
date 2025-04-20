package com.br.infrastructure.repositories;

import com.br.infrastructure.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    @Query("SELECT t FROM Transaction t WHERE DATE(t.timestamp) = :date")
    List<Transaction> findAllByDate(@Param("date") LocalDate date);
}
