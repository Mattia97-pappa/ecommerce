package com.example.sitoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
  @GetMapping("/")
    public String redirect() {
    
    return "redirect:/user/gestioneHome";
    }

    @GetMapping("/login")
    public String viewLogin() {
    
    return "login";

}
}
