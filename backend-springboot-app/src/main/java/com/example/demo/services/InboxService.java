package com.example.demo.services;

import com.example.demo.dto.InboxFilterDTO;
import com.example.demo.dao.SrDAO;
import com.example.demo.dto.InboxDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InboxService {
    @Autowired private SrDAO srDAO;

    public List<InboxDTO> loadData(InboxFilterDTO inboxFilterDTO){
        List<InboxDTO> inboxData = new ArrayList<>();
        if(inboxFilterDTO.getEntityType().equals("SR")){
            List<InboxDTO> srData = srDAO.findAll()
                    .stream()
                    .filter(sr -> inboxFilterDTO.getSelectedDesksIds().contains(sr.getDesk().getId()))
                    .map(InboxDTO::new)
                    .collect(Collectors.toList());
            inboxData.addAll(srData);
        }
        return inboxData;
    }
}
