package com.br.infrastructure.controller;

import com.br.infrastructure.dto.MessageDTO;
import com.br.infrastructure.dto.account.AccountDetailsDTO;
import com.br.infrastructure.dto.account.AccountRegisterDTO;
import com.br.infrastructure.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pixSystem/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> register(@RequestBody AccountRegisterDTO accountRegisterDTO){
        String message = accountService.register(accountRegisterDTO);
        return ResponseEntity.ok(new MessageDTO(message));
    }

    @GetMapping
    public ResponseEntity<List<AccountDetailsDTO>> findAll(){
        return ResponseEntity.ok(accountService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<AccountDetailsDTO> findById(@RequestParam(name = "id") String id){
        return ResponseEntity.ok(accountService.findById(UUID.fromString(id)));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(@RequestParam(name = "id") String id){
        accountService.deleteById(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}
