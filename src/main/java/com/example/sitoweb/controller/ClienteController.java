package com.example.sitoweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sitoweb.entity.Prodotti;
import com.example.sitoweb.repository.ProdottiRepository;



@Controller
@RequestMapping("/cliente")
public class ClienteController {

    
    
    @Autowired
    private ProdottiRepository prodottiRepository;


    @GetMapping("/all")
    public String viewClientePage() {
      
        return "visitatoreHome";
    }

    @GetMapping("/prodotti")
    public String viewProdottiUomo(Model model) {
        List<Prodotti> prodottiUomo = prodottiRepository.findByCategoria("uomo");
        model.addAttribute("prodotti", prodottiUomo);
        return "esploraProdotti"; 
    }



    @GetMapping("/prodottidonna")
    public String viewProdottiDonna(Model model) {
        List<Prodotti> prodottiDonna = prodottiRepository.findByCategoria("donna");
        model.addAttribute("prodotti", prodottiDonna);
        return "esploraProdottiDonna"; 
    }



    @GetMapping("/selezionaProdotto/{id}")
    public String viewProdottoDettagli(@PathVariable Integer id, Model model) {
        Optional<Prodotti> prodotto = prodottiRepository.findById(id);
        if (prodotto.isPresent()) {
            model.addAttribute("prodotto", prodotto.get());
            return "selezionaProdotto"; 
        } else {
            return "redirect:/cliente/prodotti"; 
        }
    }
}





