package com.tajbir.Security.service;

import com.tajbir.Security.dto.UserContextDTO;
import com.tajbir.Security.dto.UserRegisterDTO;
import com.tajbir.Security.mapper.UserMapper;
import com.tajbir.Security.model.Users;
import com.tajbir.Security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserContextDTO register(UserRegisterDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        LOGGER.info("User password encoded: {}", user.getPassword());

        Users userModel = userMapper.UserRegisterDTOToUsersEntity(user);
        LOGGER.info("User entity created: {}", userModel.toString());
        userRepository.save(userModel);

        LOGGER.info("User saved to database: {}", userModel.toString());
        return userMapper.userEntityToUserContextDTO(userModel);
    }
}
