package com.example.sitoweb.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sitoweb.entity.Ordini;
import com.example.sitoweb.entity.Prodotti;
import com.example.sitoweb.entity.User;
import com.example.sitoweb.repository.OrdiniRepository;
import com.example.sitoweb.repository.ProdottiRepository;
import com.example.sitoweb.repository.UserRepository;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/ordine")
public class OrdineClienteController {
    
@Autowired
    private UserRepository userRepository;


    @Autowired
    private OrdiniRepository ordiniRepository;

    @Autowired
    private ProdottiRepository prodottiRepository;



 
    @GetMapping("/crea")
    public String mostraPaginaOrdine(@RequestParam("idProdotto") int idProdotto, Model model) {
        Optional<Prodotti> prodottoOpt = prodottiRepository.findById(idProdotto);
        if (prodottoOpt.isPresent()) {
            model.addAttribute("prodotto", prodottoOpt.get());
            return "creaOrdine"; 
        }
        return "redirect:/cliente/all";
    }

    
    @PostMapping("/crea")
    public String creaOrdine(@RequestParam("idProdotto") int idProdotto,
    @RequestParam("metodo_pagamento") String metodo_pagamento,     
    @RequestParam("taglia") String taglia,                    
    @RequestParam("quantita") int quantita, //
    HttpSession session,
                             Model model) {

        User cliente = (User) session.getAttribute("clienteLoggato");
        if (cliente == null) {
            return "redirect:/loginCliente";
        }

        Optional<Prodotti> prodottoOpt = prodottiRepository.findById(idProdotto);
        if (prodottoOpt.isEmpty()) {
            return "redirect:/cliente/all";
        }

        Prodotti prodotto = prodottoOpt.get();

        int prezzoUnitario = Integer.parseInt(prodotto.getPrezzo()); 
        int importoTotale = prezzoUnitario * quantita;


        Ordini ordine = new Ordini();
        ordine.setId_cliente(cliente.getId());
        ordine.setId_prodotto(prodotto.getId());
        ordine.setData_ordine(LocalDate.now());
        ordine.setImporto(importoTotale);
        ordine.setMetodo_pagamento(metodo_pagamento); 
        ordine.setTaglia(taglia);
        ordine.setQuantita(quantita);

        ordiniRepository.save(ordine);

        model.addAttribute("prodotto", prodotto);
        model.addAttribute("cliente", cliente);
        model.addAttribute("ordine", ordine);

        return "confermaOrdine"; 
    }
}





