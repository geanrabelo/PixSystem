package com.br.infrastructure.controller;

import com.br.infrastructure.dto.MessageDTO;
import com.br.infrastructure.dto.settlement.SettlementDetailsDTO;
import com.br.infrastructure.dto.settlement.SettlementRegisterDTO;
import com.br.infrastructure.service.SettlementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pixSystem/settlement")
public class SettlementController {

    private final SettlementService settlementService;

    public SettlementController(SettlementService settlementService){
        this.settlementService = settlementService;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> generateSettlementBatch(@RequestBody SettlementRegisterDTO settlementRegisterDTO){
        settlementService.generateSettlementBatch(settlementRegisterDTO);
        return ResponseEntity.ok(new MessageDTO("Settlement Registered successfully"));
    }

    @GetMapping
    public ResponseEntity<List<SettlementDetailsDTO>> findAll(){
        return ResponseEntity.ok(settlementService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<SettlementDetailsDTO> findById(@RequestParam("id") String id){
        return ResponseEntity.ok(settlementService.findById(UUID.fromString(id)));
    }
}
