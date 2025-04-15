package com.example.sitoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sitoweb.entity.Ordini;

public interface OrdiniRepository extends JpaRepository<Ordini, Integer> {
    
}
