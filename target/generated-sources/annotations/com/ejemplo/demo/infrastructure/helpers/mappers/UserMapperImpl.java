package com.ejemplo.demo.infrastructure.helpers.mappers;

import com.ejemplo.demo.api.dto.request.UserCreateRequest;
import com.ejemplo.demo.api.dto.request.UserUpdateRequest;
import com.ejemplo.demo.api.dto.response.UserBasicResponse;
import com.ejemplo.demo.api.dto.response.UserResponse;
import com.ejemplo.demo.domain.entities.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-30T23:03:26-0500",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toUserCreateEntity(UserCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.username( request.getUsername() );
        userEntity.password( request.getPassword() );
        userEntity.email( request.getEmail() );
        userEntity.fullName( request.getFullName() );

        return userEntity.build();
    }

    @Override
    public UserEntity toUserUpdateEntity(UserUpdateRequest request, UserEntity user) {
        if ( request == null ) {
            return user;
        }

        user.setUsername( request.getUsername() );
        user.setPassword( request.getPassword() );
        user.setEmail( request.getEmail() );
        user.setFullName( request.getFullName() );
        user.setRole( request.getRole() );

        return user;
    }

    @Override
    public UserResponse toUserResponse(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder<?, ?> userResponse = UserResponse.builder();

        userResponse.id( userEntity.getId() );
        userResponse.username( userEntity.getUsername() );
        userResponse.email( userEntity.getEmail() );
        userResponse.role( userEntity.getRole() );

        return userResponse.build();
    }

    @Override
    public UserBasicResponse toUserBasicResponse(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserBasicResponse.UserBasicResponseBuilder<?, ?> userBasicResponse = UserBasicResponse.builder();

        userBasicResponse.id( userEntity.getId() );
        userBasicResponse.username( userEntity.getUsername() );
        userBasicResponse.email( userEntity.getEmail() );
        userBasicResponse.role( userEntity.getRole() );

        return userBasicResponse.build();
    }
}
