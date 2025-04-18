package com.br.infrastructure.controller;

import com.br.infrastructure.dto.MessageDTO;
import com.br.infrastructure.dto.pixKey.PixKeyDetailsDTO;
import com.br.infrastructure.dto.pixKey.PixKeyRegisterDTO;
import com.br.infrastructure.service.PixKeyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pixSystem/pixKey")
public class PixKeyController {

    private final PixKeyService pixKeyService;

    public PixKeyController(PixKeyService pixKeyService){
        this.pixKeyService = pixKeyService;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> register(@RequestBody PixKeyRegisterDTO pixKeyRegisterDTO){
        String message = pixKeyService.register(pixKeyRegisterDTO);
        return ResponseEntity.ok(new MessageDTO(message));
    }

    @GetMapping
    public ResponseEntity<List<PixKeyDetailsDTO>> findAll(){
        return ResponseEntity.ok(pixKeyService.findAll());
    }

    @GetMapping("id")
    public ResponseEntity<PixKeyDetailsDTO> findById(@RequestParam(name = "id") String uuid){
        return ResponseEntity.ok(pixKeyService.findById(UUID.fromString(uuid)));
    }

    @GetMapping("/byAccount")
    public ResponseEntity<List<PixKeyDetailsDTO>> findByAccount(@RequestParam(name = "accountId") String uuid){
        return ResponseEntity.ok(pixKeyService.findByAccountId(UUID.fromString(uuid)));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam(name = "id") String uuid){
        pixKeyService.deleteById(UUID.fromString(uuid));
        return ResponseEntity.noContent().build();
    }
}
