package com.example.demo.dto;

import java.util.List;

public class InboxFilterDTO {
    private String entityType;
    private List<String> selectedDesksIds;
    private Long userId;

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityType() {
        return entityType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getSelectedDesksIds() {
        return selectedDesksIds;
    }

    public void setSelectedDesksIds(List<String> selectedDesksIds) {
        this.selectedDesksIds = selectedDesksIds;
    }
}
