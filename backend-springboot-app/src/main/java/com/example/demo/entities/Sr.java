package com.example.demo.entities;

import java.time.LocalDateTime;

public class Sr {
    private String id;
    private User creatorUser;
    private String summary;
    private Desk desk;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private String status;

    public Sr(){}

    public Sr(String summary, Desk desk, User creatorUser) {
        this.creatorUser = creatorUser;
        this.summary = summary;
        this.desk = desk;
        this.creationDate = LocalDateTime.now();
        this.lastUpdate = LocalDateTime.now();
        this.status = "CREATED";
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public User getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(User creatorUser) {
        this.creatorUser = creatorUser;
    }
}
