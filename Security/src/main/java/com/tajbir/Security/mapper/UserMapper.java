package com.tajbir.Security.mapper;

import com.tajbir.Security.dto.UserContextDTO;
import com.tajbir.Security.dto.UserRegisterDTO;
import com.tajbir.Security.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "password", source = "user.password")
    Users UserRegisterDTOToUsersEntity(UserRegisterDTO user);

    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "password", source = "user.password")
    UserContextDTO userEntityToUserContextDTO(Users user);
}
