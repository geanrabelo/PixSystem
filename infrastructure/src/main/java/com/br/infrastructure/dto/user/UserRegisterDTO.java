package com.br.infrastructure.dto.user;

import com.br.core.entities.UserEntity;

public record UserRegisterDTO(String name, String cpf, String emails, String phone){

    public UserEntity toUserEntity(){
        return new UserEntity(this.name, this.cpf, this.emails, this.phone);
    }
}
