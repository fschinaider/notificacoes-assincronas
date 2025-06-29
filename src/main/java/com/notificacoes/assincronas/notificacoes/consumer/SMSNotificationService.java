package com.notificacoes.assincronas.notificacoes.consumer;

import com.notificacoes.assincronas.notificacoes.model.UserEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SMSNotificationService {

    @RabbitListener(queues = "sms.queue")
    public void receber(UserEvent evento) {
        System.out.println("📱 Enviando SMS para: " + evento.getPhone() +
                " | ID do usuário: " + evento.getUserId() +
                " | E-mail: " + evento.getEmail());
    }
}
