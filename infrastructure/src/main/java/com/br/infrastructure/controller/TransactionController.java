package com.br.infrastructure.controller;

import com.br.infrastructure.dto.MessageDTO;
import com.br.infrastructure.dto.transaction.TransactionRegisterDTO;
import com.br.infrastructure.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
