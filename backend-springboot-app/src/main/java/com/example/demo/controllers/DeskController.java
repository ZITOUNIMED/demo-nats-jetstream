package com.example.demo.controllers;

import com.example.demo.dto.DeskDTO;
import com.example.demo.services.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/desks")
@CrossOrigin("*")
public class DeskController {
    @Autowired
    DeskService deskService;

    @GetMapping("/by-user-id/{userId}")
    public ResponseEntity<List<DeskDTO>> getUserDesks(@PathVariable("userId") Long userId){
        List<DeskDTO> desks = deskService.getUserDesks(userId);
        return new ResponseEntity<>(desks, HttpStatus.OK);
    }
}
