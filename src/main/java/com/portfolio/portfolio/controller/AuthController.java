package com.portfolio.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.portfolio.dto.AuthResponseDTO;
import com.portfolio.portfolio.dto.LoginRequestDto;
import com.portfolio.portfolio.dto.RegisterRequestDto;
import com.portfolio.portfolio.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public ResponseEntity<String> register( @RequestBody RegisterRequestDto dto) {

        return ResponseEntity.ok(service.register(dto));
    }
    
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login( @RequestBody LoginRequestDto dto) {

        String token = service.login(dto);
        return ResponseEntity.ok(new AuthResponseDTO(token));
    }

}
