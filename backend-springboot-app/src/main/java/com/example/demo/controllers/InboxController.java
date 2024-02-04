package com.example.demo.controllers;

import com.example.demo.dto.InboxFilterDTO;
import com.example.demo.dto.InboxDTO;
import com.example.demo.services.InboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inbox")
@CrossOrigin("*")
public class InboxController {
    @Autowired
    private InboxService inboxService;

    @PostMapping("/load-data")
    public ResponseEntity<List<InboxDTO>> loadData(@RequestBody InboxFilterDTO inboxFilterDTO){
        List<InboxDTO> data = inboxService.loadData(inboxFilterDTO);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
