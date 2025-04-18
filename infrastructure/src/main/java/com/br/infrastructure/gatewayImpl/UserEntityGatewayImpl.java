package com.br.infrastructure.gatewayImpl;

import com.br.application.gateway.UserEntityGateway;
import com.br.core.entities.UserEntity;
import com.br.core.enums.EnumCode;
import com.br.core.exceptions.UserIdNotExists;
import com.br.core.exceptions.UserNotValid;
import com.br.infrastructure.domain.User;
import com.br.infrastructure.dto.user.UserDatabaseToEntityDTO;
import com.br.infrastructure.dto.user.UserJpaDTO;
import com.br.infrastructure.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UserEntityGatewayImpl implements UserEntityGateway {

    private final UserRepository userRepository;

    public UserEntityGatewayImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void register(UserEntity userEntity) {
        if(validateCpf(userEntity.getCpf()) && validateEmail(userEntity.getEmails())){
            userRepository.save(new UserJpaDTO(userEntity).toUserJPA());
        }else{
            throw new UserNotValid(EnumCode.USR0001.getMessage());
        }
    }

    @Override
    public boolean validateCpf(String cpf) {
        return !userRepository.existsByCpf(cpf);
    }

    @Override
    public boolean validateEmail(String email) {
        return !userRepository.existsByEmails(email);
    }

    @Override
    public boolean existsById(UUID id) {
        return userRepository.existsById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll().stream().map(u -> new UserDatabaseToEntityDTO(u).fromJpaForEntity()).toList();
    }

    @Override
    public UserEntity findById(UUID id) {
            User user = userRepository
                    .findById(id)
                    .orElseThrow(() -> new UserIdNotExists(EnumCode.USR0000.getMessage()));
            return new UserDatabaseToEntityDTO(user).fromJpaForEntity();
    }

    @Override
    public UserEntity update(UUID id, UserEntity newUpdateUserEntity) {
        if(existsById(id)){
            User user = userRepository.getReferenceById(id);
            if(!newUpdateUserEntity.getName().isEmpty()){
                user.setName(newUpdateUserEntity.getName());
            }
            if(!newUpdateUserEntity.getPhone().isEmpty()){
                user.setPhone(newUpdateUserEntity.getPhone());
            }
            userRepository.save(user);
            return new UserDatabaseToEntityDTO(user).fromJpaForEntity();
        }
        throw new UserIdNotExists(EnumCode.USR0000.getMessage());
    }

    @Override
    public void disable(UUID id) {
        if(existsById(id)){
            User user = userRepository.getReferenceById(id);
            user.setActive(false);
            userRepository.save(user);
        }else{
            throw new UserIdNotExists(EnumCode.USR0000.getMessage());
        }
    }

    @Override
    public void active(UUID id) {
        if(existsById(id)){
            User user = userRepository.getReferenceById(id);
            user.setActive(true);
            userRepository.save(user);
        }else{
            throw new UserIdNotExists(EnumCode.USR0000.getMessage());
        }
    }
}
