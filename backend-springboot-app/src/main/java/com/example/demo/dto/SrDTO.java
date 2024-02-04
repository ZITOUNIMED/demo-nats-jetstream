package com.example.demo.dto;

import com.example.demo.entities.Sr;

import java.time.LocalDateTime;

public class SrDTO {
    private String id;
    private Long creatorUserId;
    private String creatorUserName;
    private String summary;
    private String deskId;
    private String deskName;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private String status;

    public SrDTO() {}

    public SrDTO(Sr sr){
        this.id = sr.getId();
        this.summary = sr.getSummary();
        this.deskId = sr.getDesk().getId();
        this.deskName = sr.getDesk().getName();
        this.creatorUserId = sr.getCreatorUser().getId();
        this.creatorUserName = sr.getCreatorUser().getName();
        this.creationDate= sr.getCreationDate();
        this.lastUpdate = sr.getLastUpdate();
        this.status = sr.getStatus();
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(Long creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public String getCreatorUserName() {
        return creatorUserName;
    }

    public void setCreatorUserName(String creatorUserName) {
        this.creatorUserName = creatorUserName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDeskId() {
        return deskId;
    }

    public void setDeskId(String deskId) {
        this.deskId = deskId;
    }

    public String getDeskName() {
        return deskName;
    }

    public void setDeskName(String deskName) {
        this.deskName = deskName;
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
