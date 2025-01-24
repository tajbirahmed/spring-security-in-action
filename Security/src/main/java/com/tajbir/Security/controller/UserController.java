package com.tajbir.Security.controller;

import com.tajbir.Security.dto.UserContextDTO;
import com.tajbir.Security.dto.UserRegisterDTO;
import com.tajbir.Security.model.Users;
import com.tajbir.Security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserContextDTO> register(@RequestBody UserRegisterDTO user) {
        LOGGER.info("Registering user with username: {}", user.toString());
        return ResponseEntity.ok(userService.register(user));
    }
}
