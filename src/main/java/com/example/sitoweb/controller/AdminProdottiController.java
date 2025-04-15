package com.example.sitoweb.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sitoweb.entity.Prodotti;
import com.example.sitoweb.entity.User;
import com.example.sitoweb.repository.ProdottiRepository;

@Controller
@RequestMapping("/adminprodotti")
public class AdminProdottiController {
    
    @Autowired
    private ProdottiRepository prodottiRepository;

    private final String UPLOAD_DIR = "C:/Users/LENOVO/Desktop/sitoweb/fotodonna/";

@GetMapping("/all")
    public String listProdotti(Model model) {
    List<Prodotti> prodotti = prodottiRepository.findAll();
   model.addAttribute("prodotti",prodotti);
    return "adminProdotti";
    }


@GetMapping("/delete/{id}")
public String deleteUser(@PathVariable("id") int id) {
if(prodottiRepository.existsById(id))
prodottiRepository.deleteById(id);
return "redirect:/adminprodotti/all";
}

@GetMapping("/edit/{id}")
public String showEditForm(@PathVariable("id") int id, Model model) {
Prodotti prodotti = prodottiRepository.findById(id)
.orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
model.addAttribute("prodotti", prodotti);
return "adminEditProdotti";
}

@PostMapping("/upd")
public String updateProdotti(@ModelAttribute("prodotti") Prodotti prodotti) {
prodottiRepository.save(prodotti);
return "redirect:/adminprodotti/all";
}

@GetMapping("/new")
public String newProdotto(Model model) {
model.addAttribute("prodotti", new Prodotti());
return "adminNewProdotto";
}

@PostMapping(path="/add") 
public String addNewProdotto (@RequestParam String nome, @RequestParam String descrizione, @RequestParam String prezzo,  @RequestParam String immagineUrl, @RequestParam String categoria) {


Prodotti n = new Prodotti();

n.setNome(nome);
n.setDescrizione(descrizione);
n.setPrezzo(prezzo);
n.setImmagineUrl(immagineUrl);
n.setCategoria(categoria);

prodottiRepository.save(n);
return "redirect:/adminprodotti/all";
}


}









