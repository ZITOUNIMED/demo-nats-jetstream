package com.example.demo.dto;

import com.example.demo.entities.Sr;

import java.time.LocalDateTime;

public class InboxDTO {
    private String entityId;
    private String entityType;
    private String creatorUserName;
    private String srSummary;
    private String deskName;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private String status;

    public InboxDTO(){}

    public InboxDTO(Sr sr){
        this.entityId = sr.getId();
        this.srSummary = sr.getSummary();
        this.entityType = "SR";
        this.creatorUserName = sr.getCreatorUser().getName();
        this.deskName = sr.getDesk().getName();
        this.lastUpdate = sr.getLastUpdate();
        this.creationDate = sr.getCreationDate();
        this.status = sr.getStatus();
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getCreatorUserName() {
        return creatorUserName;
    }

    public void setCreatorUserName(String creatorUserName) {
        this.creatorUserName = creatorUserName;
    }

    public String getSrSummary() {
        return srSummary;
    }

    public void setSrSummary(String srSummary) {
        this.srSummary = srSummary;
    }

    public String getDeskName() {
        return deskName;
    }

    public void setDeskName(String deskName) {
        this.deskName = deskName;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
