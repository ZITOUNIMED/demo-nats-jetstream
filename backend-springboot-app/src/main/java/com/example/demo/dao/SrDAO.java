package com.example.demo.dao;

import com.example.demo.entities.Sr;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class SrDAO implements AbstractDAO<String, Sr> {
    private static final Map<String, Sr> SRS = new HashMap<>();

    @Override
    public Sr findById(String id) {
        return SRS.get(id);
    }

    @Override
    public void save(Sr sr) {
        if(sr.getId() == null){
            sr.setId(UUID.randomUUID().toString());
        }
        SRS.put(sr.getId(), sr);
    }

    @Override
    public List<Sr> findAll() {
        return SRS.entrySet().stream().map(e -> e.getValue())
                .collect(Collectors.toList());
    }
}
