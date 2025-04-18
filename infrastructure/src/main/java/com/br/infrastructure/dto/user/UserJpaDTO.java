package com.br.infrastructure.dto.user;

import com.br.core.entities.UserEntity;
import com.br.infrastructure.domain.User;

import java.time.LocalDateTime;

public record UserJpaDTO(UserEntity userEntity) {

    public User toUserJPA(){
        return User.builder()
                .name(this.userEntity.getName())
                .cpf(this.userEntity.getCpf())
                .phone(this.userEntity.getPhone())
                .emails(this.userEntity.getEmails())
                .createdAt(LocalDateTime.now())
                .active(true)
                .build();
    }
}
