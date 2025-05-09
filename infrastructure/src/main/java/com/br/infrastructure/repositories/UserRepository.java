package com.br.infrastructure.repositories;

import com.br.infrastructure.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByCpf(String cpf);

    boolean existsByEmails(String emails);

}
