package com.notificacoes.assincronas.notificacoes.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserEvent {
    private String userId;
    private String email;
    private String phone;
    private String timestamp;

    public UserEvent() {
        this.timestamp = gerarTimestamp();
    }

    public UserEvent(String userId, String email, String phone) {
        this.userId = userId;
        this.email = email;
        this.phone = phone;
        this.timestamp = gerarTimestamp();
    }

    private String gerarTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
