package com.example.nginxlab.service;

import com.example.nginxlab.dto.CreateUserRequest;
import com.example.nginxlab.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {

    private final Map<Long, User> users = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    public UserService() {
        // Datos iniciales
        create(new CreateUserRequest("Roberto", "roberto@test.com"));
        create(new CreateUserRequest("Ana", "ana@test.com"));
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    public User create(CreateUserRequest request) {
        long id = counter.getAndIncrement();
        User user = new User(id, request.getName(), request.getEmail());
        users.put(id, user);
        return user;
    }
}
