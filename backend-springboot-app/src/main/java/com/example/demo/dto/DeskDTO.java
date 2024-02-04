package com.example.demo.dto;

import com.example.demo.entities.Desk;

public class DeskDTO {
    private String id;
    private String name;

    public DeskDTO(){}

    public DeskDTO(Desk desk){
        this.name = desk.getName();
        this.id = desk.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
