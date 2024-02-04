package com.example.demo.dao;

import com.example.demo.entities.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserDAO implements AbstractDAO<Long, User> {
    private static final Map<Long, User> USERS = new HashMap<>();

    @Override
    public User findById(Long id) {
        return USERS.get(id);
    }

    @Override
    public void save(User user) {
        USERS.put(user.getId(), user);
    }

    @Override
    public List<User> findAll() {
        return USERS.entrySet().stream().map(e -> e.getValue())
                .collect(Collectors.toList());
    }
}
