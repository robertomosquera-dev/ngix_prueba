package com.example.nginxlab.service;

import com.example.nginxlab.dto.CreateUserRequest;
import com.example.nginxlab.model.User;
import com.example.nginxlab.repository.UserReponsitory;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserReponsitory reponsitory;

    public List<User> findAll() {
        return reponsitory.findAll();
    }

    public User findById(UUID id) {
        return reponsitory.findById(id).orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
    }

    public User create(CreateUserRequest request) {
        return reponsitory.save(
            User
            .builder()
            .name(request.getName())
            .email(request.getEmail())
            .build() 
        );
    }
}
