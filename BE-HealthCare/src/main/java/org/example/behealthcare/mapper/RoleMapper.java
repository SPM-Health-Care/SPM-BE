package org.example.behealthcare.mapper;

import org.example.behealthcare.dto.request.RoleRequest;
import org.example.behealthcare.dto.response.RoleResponse;
import org.example.behealthcare.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
