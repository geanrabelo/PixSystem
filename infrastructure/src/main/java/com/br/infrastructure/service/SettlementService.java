package com.br.infrastructure.service;

import com.br.infrastructure.dto.settlement.SettlementDetailsDTO;
import com.br.infrastructure.dto.settlement.SettlementRegisterDTO;
import com.br.usecases.SettlementEntityUsecases;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SettlementService {

    private final SettlementEntityUsecases settlementEntityUsecases;

    public SettlementService(SettlementEntityUsecases settlementEntityUsecases){
        this.settlementEntityUsecases = settlementEntityUsecases;
    }

    public void generateSettlementBatch(SettlementRegisterDTO settlementRegisterDTO){
        settlementEntityUsecases.generateSettlementBatch(settlementRegisterDTO.toEntity());
    }

    public List<SettlementDetailsDTO> findAll(){
        return settlementEntityUsecases.findAll().stream().map(SettlementDetailsDTO::new).toList();
    }

    public SettlementDetailsDTO findById(UUID id){
        return new SettlementDetailsDTO(settlementEntityUsecases.findById(id));
    }
}
