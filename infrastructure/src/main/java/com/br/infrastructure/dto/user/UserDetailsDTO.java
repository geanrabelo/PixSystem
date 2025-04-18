package com.br.infrastructure.dto.user;

import com.br.core.entities.UserEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserDetailsDTO(UUID id, String name, String cpf, String emails, String phone, LocalDateTime createdAt, Boolean active) {

    public UserDetailsDTO(UserEntity userEntity){
        this(userEntity.getId(),
                userEntity.getName(),
                userEntity.getCpf(),
                userEntity.getEmails(),
                userEntity.getPhone(),
                userEntity.getCreatedAt(),
                userEntity.getActive());
    }

}
