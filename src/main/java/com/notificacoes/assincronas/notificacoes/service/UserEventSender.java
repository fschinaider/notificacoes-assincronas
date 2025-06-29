package com.notificacoes.assincronas.notificacoes.service;

import com.notificacoes.assincronas.notificacoes.model.UserEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEventSender {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public UserEventSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendUserEvent(UserEvent event) {
        rabbitTemplate.convertAndSend("notificacoes.exchange", "", event);
    }
}
