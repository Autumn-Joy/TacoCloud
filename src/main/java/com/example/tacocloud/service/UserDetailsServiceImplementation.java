package com.example.tacocloud.service;

import com.example.tacocloud.domain.User;
import com.example.tacocloud.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    
    private final UserRepository userRepo;
    
    public UserDetailsServiceImplementation(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails userDetails = userRepo.findByUsername(username);

        if (userDetails == null) {
            throw new UsernameNotFoundException(
                    "User not found with username: " + username
            );
        }

        return userDetails;

    }
}
