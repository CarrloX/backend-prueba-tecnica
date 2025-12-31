package com.ejemplo.demo.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.ejemplo.demo.api.dto.request.UserCreateRequest;
import com.ejemplo.demo.api.dto.request.UserUpdateRequest;
import com.ejemplo.demo.api.dto.response.UserBasicResponse;
import com.ejemplo.demo.api.dto.response.UserResponse;
import com.ejemplo.demo.domain.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    UserEntity toUserCreateEntity(UserCreateRequest request);

    @Mapping(target = "id", ignore = true)
    UserEntity toUserUpdateEntity(UserUpdateRequest request, @MappingTarget UserEntity user);

    UserResponse toUserResponse(UserEntity userEntity);

    UserBasicResponse toUserBasicResponse(UserEntity userEntity);
}
