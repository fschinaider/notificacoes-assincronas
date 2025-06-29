package com.notificacoes.assincronas.notificacoes.consumer;

import com.notificacoes.assincronas.notificacoes.model.UserEvent;
import com.notificacoes.assincronas.notificacoes.store.EventStore;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

    private final EventStore eventStore;

    public EmailNotificationService(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @RabbitListener(queues = "email.queue")
    public void receber(UserEvent evento) {
        System.out.println("📧 Enviando e-mail para: " + evento.getEmail() +
                " | Nome: " + evento.getEmail());
        eventStore.addEvent(evento); 
    }
}
