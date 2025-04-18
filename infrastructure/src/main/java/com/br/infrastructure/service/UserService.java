package com.br.infrastructure.service;

import com.br.core.entities.UserEntity;
import com.br.infrastructure.domain.User;
import com.br.infrastructure.dto.user.UserDetailsDTO;
import com.br.infrastructure.dto.user.UserRegisterDTO;
import com.br.infrastructure.dto.user.UserUpdateDTO;
import com.br.usecases.UserEntityUsecases;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private UserEntityUsecases userEntityUsecases;

    public UserService(UserEntityUsecases userEntityUsecases){
        this.userEntityUsecases = userEntityUsecases;
    }

    public String register(UserRegisterDTO userRegisterDTO){
        userEntityUsecases.register(userRegisterDTO.toUserEntity());
        return "User Registered successfully";
    }

    public List<UserDetailsDTO> findAll(){
        return userEntityUsecases.findAll().stream().map(u -> new UserDetailsDTO(
                u.getId(),
                u.getName(),
                u.getCpf(),
                u.getEmails(),
                u.getPhone(),
                u.getCreatedAt(),
                u.getActive()
        )).toList();
    }

    public UserDetailsDTO findById(UUID id){
        UserEntity userEntity = userEntityUsecases.findById(id);
        return new UserDetailsDTO(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getCpf(),
                userEntity.getEmails(),
                userEntity.getPhone(),
                userEntity.getCreatedAt(),
                userEntity.getActive()
        );
    }

    public void deleteById(UUID id){
        userEntityUsecases.disable(id);
    }

    public void activeById(UUID id){
        userEntityUsecases.active(id);
    }

    public UserDetailsDTO update(UUID id, UserUpdateDTO userUpdateDTO){
        UserEntity userEntity = new UserEntity.UserEntityBuilder()
                .builder()
                .name(userUpdateDTO.name())
                .phone(userUpdateDTO.phone())
                .build();
        UserEntity userUpdated = userEntityUsecases.update(id, userEntity);
        return new UserDetailsDTO(
                userUpdated.getId(),
                userUpdated.getName(),
                userUpdated.getCpf(),
                userUpdated.getEmails(),
                userUpdated.getPhone(),
                userUpdated.getCreatedAt(),
                userUpdated.getActive()
        );
    }
}
