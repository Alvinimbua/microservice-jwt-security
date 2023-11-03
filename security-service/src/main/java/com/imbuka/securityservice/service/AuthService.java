package com.imbuka.securityservice.service;

import com.imbuka.securityservice.entity.UserCredentials;

public interface AuthService {
    String saveUser(UserCredentials userCredentials);
    String generateToken(String username);
    void validateToken(String token);
}
