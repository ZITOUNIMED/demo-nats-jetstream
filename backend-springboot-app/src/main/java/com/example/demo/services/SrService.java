package com.example.demo.services;

import com.example.demo.dao.DeskDAO;
import com.example.demo.dao.SrDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.dto.SrDTO;
import com.example.demo.dto.SrFormDTO;
import com.example.demo.entities.Desk;
import com.example.demo.entities.Sr;
import com.example.demo.entities.User;
import com.example.demo.nats.AppNatsPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SrService {
    @Autowired private SrDAO srDAO;
    @Autowired private UserDAO userDAO;
    @Autowired private DeskDAO deskDAO;
    @Autowired private AppNatsPublisher publisher;

    public SrDTO getSrOverview(String srId){
        return new SrDTO(srDAO.findById(srId));
    }

    public SrDTO createSr(SrFormDTO srFormDTO){
        Sr sr = new Sr();
        sr.setStatus("CREATED");
        sr.setCreationDate(LocalDateTime.now());
        sr.setLastUpdate(LocalDateTime.now());
        User user = userDAO.findById(srFormDTO.getCreatorUserId());
        sr.setCreatorUser(user);
        Desk desk = deskDAO.findById(srFormDTO.getDeskId());
        sr.setDesk(desk);
        sr.setSummary(srFormDTO.getSummary());

        srDAO.save(sr);
        publisher.publish(sr.getSummary());
        return new SrDTO(sr);
    }
}
