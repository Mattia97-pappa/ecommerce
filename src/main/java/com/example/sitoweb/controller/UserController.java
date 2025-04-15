package com.example.sitoweb.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sitoweb.entity.User;
import com.example.sitoweb.repository.UserRepository;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserRepository userRepository;

  
    
    
    @GetMapping("/all")
    public String listUser(Model model) {
    List<User> utenti = userRepository.findAll();
   model.addAttribute("utenti",utenti);
    return "user";
    }

@GetMapping("/gestioneHome")
public String gestioneHome(){
    return "gestioneHome";
}
  
@GetMapping("/delete/{id}")
public String deleteUser(@PathVariable("id") int id) {
if(userRepository.existsById(id))
userRepository.deleteById(id);
return "redirect:/user/all";
}


@GetMapping("/edit/{id}")
public String showEditForm(@PathVariable("id") int id, Model model) {
User user = userRepository.findById(id)
.orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
model.addAttribute("user", user);
return "editInfo";
}

@PostMapping("/upd")
public String updateUser(@ModelAttribute("user") User user) {
userRepository.save(user);
return "redirect:/user/all";
}


@GetMapping("/new")
public String newUser(Model model) {
model.addAttribute("user", new User());
return "newUser";
}

@PostMapping(path="/add") 
public String addNewUser (@RequestParam String username, @RequestParam String nome, @RequestParam String cognome, @RequestParam String email, @RequestParam String telefono, @RequestParam String citta, @RequestParam String indirizzo, @RequestParam Integer cap,@RequestParam LocalDate registrazione,@RequestParam String password ) {


User n = new User();
n.setUsername(username);
n.setNome(nome);
n.setCognome(cognome);
n.setEmail(email);
n.setTelefono(telefono);
n.setCitta(citta);
n.setIndirizzo(indirizzo);
n.setCap(cap);
n.setRegistrazione(registrazione);
n.setPassword(password);
userRepository.save(n);
return "redirect:/user/all";
}


}



