package com.example.sitoweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sitoweb.entity.Prodotti;




    
public interface ProdottiRepository extends JpaRepository<Prodotti, Integer> {
   
        List<Prodotti> findByCategoria(String categoria);
}





