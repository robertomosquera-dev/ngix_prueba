package com.example.nginxlab.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nginxlab.model.User;

@Repository
public interface UserReponsitory extends JpaRepository<User,UUID>{
  
}
