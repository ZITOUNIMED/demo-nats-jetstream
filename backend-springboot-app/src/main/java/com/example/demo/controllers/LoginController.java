package com.example.demo.controllers;

import com.example.demo.dao.UserDAO;
import com.example.demo.dto.LoginFormDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private UserDAO userDAO;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginFormDTO loginFormDTO){
        User user = userDAO.findById(loginFormDTO.getUserId());
        if(user == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
    }
}
