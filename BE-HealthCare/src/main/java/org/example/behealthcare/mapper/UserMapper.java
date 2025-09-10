package org.example.behealthcare.mapper;

import org.example.behealthcare.dto.request.UserCreationRequest;
import org.example.behealthcare.dto.request.UserUpdateRequest;
import org.example.behealthcare.dto.response.UserResponse;
import org.example.behealthcare.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;



@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
