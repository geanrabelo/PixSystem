package com.br.infrastructure.controller;

import com.br.infrastructure.dto.MessageDTO;
import com.br.infrastructure.dto.pixKey.PixKeyDetailsDTO;
import com.br.infrastructure.dto.pixKey.PixKeyRegisterDTO;
import com.br.infrastructure.service.PixKeyService;
import jakarta.transaction.Transactional;
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
    @Transactional
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
    @Transactional
    public ResponseEntity<?> delete(@RequestParam(name = "id") String uuid){
        pixKeyService.deleteById(UUID.fromString(uuid));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/active")
    @Transactional
    public ResponseEntity<MessageDTO> active(@RequestParam("id") String id){
        pixKeyService.active(UUID.fromString(id));
        return ResponseEntity.ok(new MessageDTO("Pix key activated"));
    }

    @PutMapping("/disable")
    @Transactional
    public ResponseEntity<MessageDTO> disable(@RequestParam("id") String id){
        pixKeyService.disable(UUID.fromString(id));
        return ResponseEntity.ok(new MessageDTO("Pix key disabled"));
    }
}
