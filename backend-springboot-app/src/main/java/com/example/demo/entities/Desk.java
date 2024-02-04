package com.example.demo.entities;

import java.util.List;

public class Desk {
    private String id;
    private String name;
    private List<User> users;

    public Desk(){}

    public Desk(String name, List<User> users) {
        this.name = name;
        this.users = users;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
