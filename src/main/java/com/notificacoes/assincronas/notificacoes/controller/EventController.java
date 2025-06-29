package com.notificacoes.assincronas.notificacoes.controller;

import com.notificacoes.assincronas.notificacoes.model.UserEvent;
import com.notificacoes.assincronas.notificacoes.store.EventStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventStore eventStore;

    public EventController(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @GetMapping
    public List<UserEvent> listarEventos() {
        return eventStore.getAllEvents();
    }
}
