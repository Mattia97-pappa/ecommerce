package com.example.sitoweb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sitoweb.entity.User;
import com.example.sitoweb.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ClienteAutController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/loginCliente")
    public String showLoginPage() {
        return "loginCliente";
    }

    @PostMapping("/loginCliente")
    public String loginCliente(@RequestParam String email,
                                @RequestParam String password,
                                HttpSession session,
                                Model model) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);

        if (user.isPresent()) {
            session.setAttribute("clienteLoggato", user.get());
            return "redirect:/cliente/all";
        } else {
            model.addAttribute("errore", "Email o password errati.");
            return "loginCliente";
        }
    }

    @GetMapping("/logoutCliente")
    public String logoutCliente(HttpSession session) {
        session.invalidate();
        return "redirect:/loginCliente";
    }
}

