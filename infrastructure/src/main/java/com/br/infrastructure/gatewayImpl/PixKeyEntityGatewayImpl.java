package com.br.infrastructure.gatewayImpl;

import com.br.application.gateway.PixKeyEntityGateway;
import com.br.core.entities.AccountEntity;
import com.br.core.entities.PixKeyEntity;
import com.br.core.enums.EnumCode;
import com.br.core.exceptions.PixKeyIdNotFound;
import com.br.core.exceptions.PixKeyValueAlreadyExists;
import com.br.infrastructure.dto.pixKey.PixKeyDatabaseToEntityDTO;
import com.br.infrastructure.dto.pixKey.PixKeyJpaDTO;
import com.br.infrastructure.repositories.PixKeyRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PixKeyEntityGatewayImpl implements PixKeyEntityGateway {

    private final PixKeyRepository pixKeyRepository;

    public PixKeyEntityGatewayImpl(PixKeyRepository pixKeyRepository){
        this.pixKeyRepository = pixKeyRepository;
    }

    @Override
    public void register(PixKeyEntity pixKeyEntity) {
        if(validateKeyValue(pixKeyEntity.getKeyValue())){
            pixKeyRepository.save(new PixKeyJpaDTO(pixKeyEntity).toPixKey());
        }else{
            throw new PixKeyValueAlreadyExists(EnumCode.PXK0001.getMessage());
        }
    }

    @Override
    public boolean validateKeyValue(String keyValue) {
        return !pixKeyRepository.existsByKeyValue(keyValue);
    }

    @Override
    public boolean existsById(UUID id) {
        return pixKeyRepository.existsById(id);
    }

    @Override
    public boolean existsTransactions() {
        return false;
    }

    @Override
    public List<PixKeyEntity> findAll() {
        return pixKeyRepository.findAll().stream().map(p -> new PixKeyDatabaseToEntityDTO(p).fromJpaForEntity()).toList();
    }

    @Override
    public List<PixKeyEntity> findByAccount(AccountEntity accountEntity) {
        return pixKeyRepository.findByAccountId(accountEntity.getId())
                .stream()
                .map(p -> new PixKeyDatabaseToEntityDTO(p).fromJpaForEntity()).toList();
    }

    @Override
    public PixKeyEntity findById(UUID id) {
        if(existsById(id)){
            return new PixKeyDatabaseToEntityDTO(pixKeyRepository.getReferenceById(id)).fromJpaForEntity();
        }
        throw new PixKeyIdNotFound(EnumCode.PXK0000.getMessage());
    }

    @Override
    public void delete(UUID id) {
        if(existsById(id)){
            pixKeyRepository.deleteById(id);
        }else{
            throw new PixKeyIdNotFound(EnumCode.PXK0000.getMessage());
        }
    }
}
