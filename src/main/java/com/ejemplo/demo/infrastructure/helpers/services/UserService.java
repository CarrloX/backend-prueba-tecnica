package com.ejemplo.demo.infrastructure.helpers.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ejemplo.demo.api.dto.request.LoginRequest;
import com.ejemplo.demo.api.dto.request.RegisterRequest;
import com.ejemplo.demo.api.dto.request.UserCreateRequest;
import com.ejemplo.demo.api.dto.request.UserUpdateRequest;
import com.ejemplo.demo.api.dto.response.UserBasicResponse;
import com.ejemplo.demo.api.dto.response.UserResponse;
import com.ejemplo.demo.domain.entities.UserEntity;
import com.ejemplo.demo.domain.entities.repositories.UserRepository;
import com.ejemplo.demo.infrastructure.abstract_services.IUserService;
import com.ejemplo.demo.infrastructure.helpers.generic_methods.GenericEntityService;
import com.ejemplo.demo.infrastructure.helpers.mappers.UserMapper;
import com.ejemplo.demo.utils.enums.UserRole;
import com.ejemplo.demo.utils.exceptions.InvalidCredentialsException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final GenericEntityService<UserEntity, Long> genericEntityService;

    @Override
    public UserBasicResponse create(UserCreateRequest request) {
        UserEntity userEntity = this.userMapper.toUserCreateEntity(request);
        userEntity.setRole(UserRole.CUSTOMER);
        return this.userMapper.toUserBasicResponse(this.userRepository.save(userEntity));
    }

    @Override
    public UserBasicResponse register(RegisterRequest request) {
        UserEntity userEntity = UserEntity.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .username(request.getEmail()) // usar email como username por defecto
                .fullName("Usuario") // nombre por defecto
                .role(UserRole.CUSTOMER)
                .build();
        return this.userMapper.toUserBasicResponse(this.userRepository.save(userEntity));
    }

    @Override
    public UserResponse get(Long id) {
        UserEntity userEntity = this.genericEntityService.find(userRepository, id, "UserEntity");
        return this.userMapper.toUserResponse(userEntity);
    }

    @Override
    public UserResponse update(UserUpdateRequest request, Long id) {
        UserEntity userEntity = this.genericEntityService.find(userRepository, id, "UserEntity");
        userEntity = this.userMapper.toUserUpdateEntity(request, userEntity);
        return this.userMapper.toUserResponse(this.userRepository.save(userEntity));

    }

    @Override
    public void delete(Long id) {
        UserEntity userEntity = this.genericEntityService.find(userRepository, id, "UserEntity");
        this.userRepository.delete(userEntity);

    }

    @Override
    public UserBasicResponse login(LoginRequest request) {
        UserEntity userEntity = this.userRepository.findByEmail(request.getEmail());
        if (userEntity == null || !userEntity.getPassword().equals(request.getPassword())) {
            throw new InvalidCredentialsException();
        }
        return this.userMapper.toUserBasicResponse(userEntity);
    }
}
