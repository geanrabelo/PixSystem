package com.br.infrastructure.controller;

import com.br.infrastructure.dto.MessageDTO;
import com.br.infrastructure.dto.refund.RefundDetailsDTO;
import com.br.infrastructure.dto.refund.RefundProcessDTO;
import com.br.infrastructure.dto.refund.RefundRequestDTO;
import com.br.infrastructure.service.RefundService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pixSystem/refund")
public class RefundController {

    private final RefundService refundService;

    public RefundController(RefundService refundService){
        this.refundService = refundService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MessageDTO> requestRefund(@RequestBody RefundRequestDTO refundRequestDTO){
        refundService.requestRefund(refundRequestDTO);
        return ResponseEntity.ok(new MessageDTO("Refund Registered successfully"));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<MessageDTO> processedRefund(@RequestParam("id") String id, @RequestBody RefundProcessDTO refundProcessDTO){
        refundService.processedRefund(UUID.fromString(id), refundProcessDTO);
        return ResponseEntity.ok(new MessageDTO("Refund Processed successfully"));
    }

    @GetMapping
    public ResponseEntity<List<RefundDetailsDTO>> findAll(){
        return ResponseEntity.ok(refundService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<RefundDetailsDTO> findById(@RequestParam("id") String id){
        return ResponseEntity.ok(refundService.findById(UUID.fromString(id)));
    }
}
