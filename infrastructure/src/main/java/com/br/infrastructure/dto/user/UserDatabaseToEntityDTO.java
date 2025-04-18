package com.br.infrastructure.dto.user;

import com.br.core.entities.UserEntity;
import com.br.infrastructure.domain.User;

public record UserDatabaseToEntityDTO(User user) {

    public UserEntity fromJpaForEntity(){
        return new UserEntity.UserEntityBuilder()
                .builder()
                .id(this.user.getId())
                .name(this.user.getName())
                .cpf(this.user.getCpf())
                .phone(this.user.getPhone())
                .emails(this.user.getEmails())
                .active(this.user.getActive())
                .createdAt(this.user.getCreatedAt())
                .build();
    }
}
