package com.tajbir.Security.principle;

import com.tajbir.Security.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserPrinciple implements UserDetails {

    private final Users users;

    public UserPrinciple(Users users) {
        this.users = users;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "read");
    }
    public String getPassword() {
        return users.getPassword();
    }
    public String getUsername() {
        return users.getUsername();
    }
}
