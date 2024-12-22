package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class UserManagementConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetailsManager userDetails = new InMemoryUserDetailsManager();
        UserDetails user = User
                .withUsername("tajbir")
                .password("123456")
                .authorities("read")
                .build();
        userDetails.createUser(user);
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
