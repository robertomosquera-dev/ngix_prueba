package com.example.nginxlab.controller;

import com.example.nginxlab.dto.CreateUserRequest;
import com.example.nginxlab.model.User;
import com.example.nginxlab.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody CreateUserRequest request) {
        User created = userService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
