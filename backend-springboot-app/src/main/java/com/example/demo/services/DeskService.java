package com.example.demo.services;

import com.example.demo.dao.DeskDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.dto.DeskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeskService {
    @Autowired private UserDAO userDAO;
    @Autowired private DeskDAO deskDAO;

    public List<DeskDTO> getUserDesks(Long userId){
        return deskDAO.findAll()
                .stream()
                .filter(d -> d.getUsers().stream() .anyMatch(u -> u.getId().equals(userId)))
                .map(DeskDTO::new)
                .collect(Collectors.toList());
    }
}
