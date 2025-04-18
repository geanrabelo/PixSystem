package com.br.infrastructure.controller;

import com.br.infrastructure.dto.MessageDTO;
import com.br.infrastructure.dto.user.UserDetailsDTO;
import com.br.infrastructure.dto.user.UserRegisterDTO;
import com.br.infrastructure.dto.user.UserUpdateDTO;
import com.br.infrastructure.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pixSystem/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> register(@RequestBody @Valid UserRegisterDTO userRegisterDTO){
        String message = userService.register(userRegisterDTO);
        var uri = UriComponentsBuilder.fromPath("/pixSystem/user").buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(new MessageDTO(message));
    }

    @GetMapping
    public ResponseEntity<List<UserDetailsDTO>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<UserDetailsDTO> findById(@RequestParam(name = "id") String uuid){
        return ResponseEntity.ok(userService.findById(UUID.fromString(uuid)));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(@RequestParam(name = "id") String uuid){
        userService.deleteById(UUID.fromString(uuid));
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<UserDetailsDTO> update(@RequestParam(name = "id") String uuid, @RequestBody UserUpdateDTO userUpdateDTO){
        return ResponseEntity.ok(userService.update(UUID.fromString(uuid), userUpdateDTO));
    }

    @PutMapping("/active")
    public ResponseEntity<MessageDTO> active(@RequestParam(name = "id") String uuid){
        userService.activeById(UUID.fromString(uuid));
        return ResponseEntity.ok(new MessageDTO("User activated"));
    }
}
