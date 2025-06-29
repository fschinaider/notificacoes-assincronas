package com.notificacoes.assincronas.notificacoes.store;

import com.notificacoes.assincronas.notificacoes.model.UserEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class EventStore {
    private final List<UserEvent> events = new CopyOnWriteArrayList<>();

    public void addEvent(UserEvent event) {
        events.add(event);
    }

    public List<UserEvent> getAllEvents() {
        return events;
    }
}
