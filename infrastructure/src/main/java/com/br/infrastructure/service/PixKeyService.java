package com.br.infrastructure.service;

import com.br.core.entities.AccountEntity;
import com.br.core.entities.PixKeyEntity;
import com.br.infrastructure.dto.pixKey.PixKeyDetailsDTO;
import com.br.infrastructure.dto.pixKey.PixKeyRegisterDTO;
import com.br.usecases.AccountEntityUsecases;
import com.br.usecases.PixKeyEntityUsecases;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PixKeyService {

    private final PixKeyEntityUsecases pixKeyEntityUsecases;
    private final AccountEntityUsecases accountEntityUsecases;

    public PixKeyService(PixKeyEntityUsecases pixKeyEntityUsecases, AccountEntityUsecases accountEntityUsecases){
        this.pixKeyEntityUsecases = pixKeyEntityUsecases;
        this.accountEntityUsecases = accountEntityUsecases;
    }

    public String register(PixKeyRegisterDTO pixKeyRegisterDTO){
        AccountEntity accountEntity = accountEntityUsecases.findById(UUID.fromString(pixKeyRegisterDTO.accountId()));
        pixKeyEntityUsecases.register(new PixKeyEntity.PixKeyBuilder()
                .builder()
                .keyValue(pixKeyRegisterDTO.keyValue())
                .keyType(pixKeyRegisterDTO.keyType())
                .accountEntity(accountEntity)
                .createdAt(LocalDateTime.now())
                .active(true)
                .build()
        );
        return "PixKey Registered successfully";
    }

    public List<PixKeyDetailsDTO> findAll(){
        return pixKeyEntityUsecases.findAll().stream().map(PixKeyDetailsDTO::new).toList();
    }

    public PixKeyDetailsDTO findById(UUID id){
        return new PixKeyDetailsDTO(pixKeyEntityUsecases.findById(id));
    }

    public List<PixKeyDetailsDTO> findByAccountId(UUID id){
        AccountEntity accountEntity = accountEntityUsecases.findById(id);
        List<PixKeyEntity> pixKeyEntityList = pixKeyEntityUsecases.findByAccount(accountEntity);
        return pixKeyEntityList.stream().map(PixKeyDetailsDTO::new).toList();
    }

    public void deleteById(UUID id){
        pixKeyEntityUsecases.delete(id);
    }
}
