package com.example.sitoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import com.example.sitoweb.entity.AdmUser;





public interface AdmUserRepository extends JpaRepository<AdmUser, Integer> {
@NativeQuery("SELECT * FROM `AdmUser` WHERE username= ?1 LIMIT 1")
AdmUser findByUsername(String username); 
}