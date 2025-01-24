package com.tajbir.Security.service;


import com.tajbir.Security.model.Users;
import com.tajbir.Security.principle.UserPrinciple;
import com.tajbir.Security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private static final Logger LOGGER = Logger.getLogger(CustomUserDetailsService.class.getName());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username);
        if (users == null) {
            LOGGER.info("User not found");
            throw new UsernameNotFoundException("User not found");
        } else {
            LOGGER.info("User found");
            return new UserPrinciple(users);
        }
    }
}