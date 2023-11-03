package com.imbuka.securityservice.config;

import com.imbuka.securityservice.entity.UserCredentials;
import com.imbuka.securityservice.repository.UserCredentialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserCredentialRepository userCredentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<UserCredentials> credentials =  userCredentialRepository.findByName(username);
        return credentials.map(CustomUserDetails::new).orElseThrow( () -> new UsernameNotFoundException("user not found with name :" + username));
    }
}
