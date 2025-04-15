package com.example.sitoweb.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sitoweb.entity.User;
import com.example.sitoweb.repository.UserRepository;

@Controller
@RequestMapping("/registrazionecliente")
public class ClienteRegistrazioneController {
    
    @Autowired    
    private UserRepository userRepository;

    @GetMapping("/new")
    public String newRegistrazione(Model model) {
        
        User nuovo = new User();
        nuovo.setRegistrazione(LocalDate.now());
        model.addAttribute("user", nuovo);
        return "clientenew";
    }

    @PostMapping(path="/add") 
    public String addNuovaregistrazione (
            @RequestParam String username, 
            @RequestParam String nome, 
            @RequestParam String cognome, 
            @RequestParam String email, 
            @RequestParam String telefono, 
            @RequestParam String citta, 
            @RequestParam String indirizzo, 
            @RequestParam Integer cap,
            
            @RequestParam String password ) {

        User n = new User();
        n.setUsername(username);
        n.setNome(nome);
        n.setCognome(cognome);
        n.setEmail(email);
        n.setTelefono(telefono);
        n.setCitta(citta);
        n.setIndirizzo(indirizzo);
        n.setCap(cap);
        
        n.setRegistrazione(LocalDate.now());
        n.setPassword(password);
        userRepository.save(n);
        return "redirect:/registrazionecliente/effettuata";
    }

    @GetMapping("/effettuata")
    public String registratoSuccesso(){
        return "registrazioneclienteavvenuta";
    }
}
