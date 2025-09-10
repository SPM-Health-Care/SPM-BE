package org.example.behealthcare.mapper;

import org.example.behealthcare.dto.request.PermissionRequest;
import org.example.behealthcare.dto.response.PermissionResponse;
import org.example.behealthcare.entity.Permission;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
