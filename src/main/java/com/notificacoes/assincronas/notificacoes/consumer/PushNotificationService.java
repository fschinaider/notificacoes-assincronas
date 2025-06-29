package com.notificacoes.assincronas.notificacoes.consumer;

import com.notificacoes.assincronas.notificacoes.model.UserEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationService {

    @RabbitListener(queues = "push.queue")
    public void receber(UserEvent evento) {
        System.out.println("🔔 Enviando notificação push para o usuário ID: " + evento.getUserId() +
                " | E-mail: " + evento.getEmail() +
                " | Telefone: " + evento.getPhone());
    }
}
