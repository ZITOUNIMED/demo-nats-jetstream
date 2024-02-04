package com.example.demo.controllers;

import com.example.demo.dto.SrDTO;
import com.example.demo.dto.SrFormDTO;
import com.example.demo.services.SrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sr")
@CrossOrigin("*")
public class SrController {
    @Autowired
    private SrService srService;

    @GetMapping("/{srId}")
    public ResponseEntity<SrDTO> srOverview (@PathVariable("srId") String srId){
        SrDTO srDTO = srService.getSrOverview(srId);
        return new ResponseEntity<>(srDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<SrDTO> createSr(@RequestBody SrFormDTO srFormDTO){
        SrDTO srDTO = srService.createSr(srFormDTO);
        return new ResponseEntity<>(srDTO, HttpStatus.OK);
    }
}
