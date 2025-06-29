package com.notificacoes.assincronas.notificacoes.controller;

import com.notificacoes.assincronas.notificacoes.model.UserEvent;
import com.notificacoes.assincronas.notificacoes.service.UserEventSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserEventSender userEventSender;

    @Autowired
    public UserController(UserEventSender userEventSender) {
        this.userEventSender = userEventSender;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserEvent userEvent) {
        userEventSender.sendUserEvent(userEvent);
        return ResponseEntity.ok("Evento de usuário enviado com sucesso!");
    }
}   
