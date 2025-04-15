package com.example.sitoweb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sitoweb.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailAndPassword(String email, String password);
}
