package com.portfolio.portfolio.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.portfolio.portfolio.dto.LoginRequestDto;
import com.portfolio.portfolio.dto.RegisterRequestDto;
import com.portfolio.portfolio.entity.Role;
import com.portfolio.portfolio.entity.User;
import com.portfolio.portfolio.repository.RoleRepository;
import com.portfolio.portfolio.repository.UserRepository;
import com.portfolio.portfolio.security.JwtService;

@Service
public class AuthService {
	@Autowired
    private UserRepository repo;
	@Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private RoleRepository roleRepo;
    
    public String register(RegisterRequestDto dto) {

        if (repo.existByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }

        User user = new User();
        user.setUsername(dto.getName());
        user.setEmail(dto.getEmail());

        //Encrypt password
        user.setPassword_hash(encoder.encode(dto.getPassword()));
        // Find Role ADMIN from DB
        Role adminRole = roleRepo.findByName("ADMIN")
                .orElseThrow(() -> new RuntimeException("Role ADMIN not found"));

        //Assign role
        user.setRoles(Set.of(adminRole));
        repo.save(user);

        return "User Registered Successfully!";
    }
    
    public String login(LoginRequestDto dto) {

        User user = repo.findByEmail(dto.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid Email!")
                );

        if (!encoder.matches(dto.getPassword(), user.getPassword_hash())) {
            throw new RuntimeException("Invalid Password!");
        }

        //Generate Token
        return jwtService.generateToken(user.getEmail());
}
}
