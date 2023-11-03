package com.imbuka.securityservice.controller;

import com.imbuka.securityservice.dto.AuthRequest;
import com.imbuka.securityservice.entity.UserCredentials;
import com.imbuka.securityservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredentials userCredentials) {
        return authService.saveUser(userCredentials);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authenticate.isAuthenticated()) {
            return authService.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("Access denied");
        }

    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
         authService.validateToken(token);
         return "Token is valid";
    }


}
