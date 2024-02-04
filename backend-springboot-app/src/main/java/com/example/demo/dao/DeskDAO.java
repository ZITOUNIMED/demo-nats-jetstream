package com.example.demo.dao;

import com.example.demo.entities.Desk;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class DeskDAO implements AbstractDAO<String, Desk>{
    private static final Map<String, Desk> DESKS = new HashMap<>();
    @Override
    public Desk findById(String id) {
        return DESKS.get(id);
    }

    @Override
    public void save(Desk desk) {
        if(desk.getId() == null){
            desk.setId(UUID.randomUUID().toString());
        }
        DESKS.put(desk.getId(), desk);
    }

    @Override
    public List<Desk> findAll() {
        return DESKS.entrySet().stream().map(e -> e.getValue())
                .collect(Collectors.toList());
    }
}
