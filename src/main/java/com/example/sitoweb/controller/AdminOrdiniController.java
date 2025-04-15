package com.example.sitoweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sitoweb.entity.Ordini;
import com.example.sitoweb.entity.User;
import com.example.sitoweb.repository.OrdiniRepository;

@Controller
@RequestMapping("/adminordini")
public class AdminOrdiniController {

@Autowired
    private OrdiniRepository ordiniRepository;

@GetMapping("/all")
    public String lisOrdini(Model model) {
    List<Ordini> ordini = ordiniRepository.findAll();
   model.addAttribute("ordini",ordini);
    return "adminOrdini";
    }
    

@GetMapping("/delete/{id}")
public String deleteOrder(@PathVariable("id") int id) {
if(ordiniRepository.existsById(id))
ordiniRepository.deleteById(id);
return "redirect:/adminordini/all";
}


@GetMapping("/edit/{id}")
public String showEditForm(@PathVariable("id") int id, Model model) {
Ordini ordini = ordiniRepository.findById(id)
.orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
model.addAttribute("ordini", ordini);
return "AdminEditOrder";
}

@PostMapping("/upd")
public String updateOrdini(@RequestParam Integer id,
                            @RequestParam Integer importo,
                            @RequestParam String taglia,
                            @RequestParam String metodo_pagamento,
                            @RequestParam Integer quantita
                            ) {
    
    Optional<Ordini> ordineOptional = ordiniRepository.findById(id);
    if (ordineOptional.isPresent()) {
        Ordini ordine = ordineOptional.get();

        
        ordine.setImporto(importo);
        ordine.setTaglia(taglia);
        ordine.setMetodo_pagamento(metodo_pagamento);
        ordine.setQuantita(quantita);

       
        ordiniRepository.save(ordine);

        return "redirect:/adminordini/all";
    } else {
        
        return "redirect:/errore";
    }
}



}
