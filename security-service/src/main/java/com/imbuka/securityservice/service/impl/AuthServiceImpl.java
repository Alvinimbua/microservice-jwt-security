package com.imbuka.securityservice.service.impl;

import com.imbuka.securityservice.entity.UserCredentials;
import com.imbuka.securityservice.repository.UserCredentialRepository;
import com.imbuka.securityservice.service.AuthService;
import com.imbuka.securityservice.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserCredentialRepository userCredentialRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    @Override
    public String saveUser(UserCredentials userCredentials) {
        //to encode the password before saving
        userCredentials.setPassword(passwordEncoder.encode(userCredentials.getPassword()));
        userCredentialRepository.save(userCredentials);
        return "User added to the system successfully";
    }

    @Override
    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    @Override
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
