package com.br.infrastructure.controller;

import com.br.infrastructure.dto.MessageDTO;
import com.br.infrastructure.dto.transaction.TransactionDataDetailsDTO;
import com.br.infrastructure.dto.transaction.TransactionRegisterDTO;
import com.br.infrastructure.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pixSystem/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> sendPix(@RequestBody TransactionRegisterDTO transactionRegisterDTO){
        String message = transactionService.sendPix(transactionRegisterDTO);
        return ResponseEntity.ok(new MessageDTO(message));
    }

    @GetMapping
    public ResponseEntity<List<TransactionDataDetailsDTO>> findAll(){
        return ResponseEntity.ok(transactionService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<TransactionDataDetailsDTO> findById(@RequestParam("id") String id){
        return ResponseEntity.ok(transactionService.findById(UUID.fromString(id)));
    }
}
