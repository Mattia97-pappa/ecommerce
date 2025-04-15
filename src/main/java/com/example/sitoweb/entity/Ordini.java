package com.example.sitoweb.entity;

import java.time.LocalDate;
import java.util.stream.Gatherer.Integrator;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordini")
public class Ordini {
    
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ordine")
    private Integer id;


    @Column(name = "id_cliente")
  private Integer id_cliente;

  @Column(name = "data_ordine")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate data_ordine;

  @Column(name = "importo")
  private Integer importo;

  @Column(name = "metodo_pagamento")
  private String metodo_pagamento;

  @Column(name = "id_prodotto")
  private Integer id_prodotto;

  @Column(name = "taglia")
  private String taglia;

  @Column(name = "quantita")
  private Integer quantita;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId_cliente() {
    return id_cliente;
  }

  public void setId_cliente(Integer id_cliente) {
    this.id_cliente = id_cliente;
  }

  public LocalDate getData_ordine() {
    return data_ordine;
  }

  public void setData_ordine(LocalDate data_ordine) {
    this.data_ordine = data_ordine;
  }

  public Integer getImporto() {
    return importo;
  }

  public void setImporto(Integer importo) {
    this.importo = importo;
  }

  public String getMetodo_pagamento() {
    return metodo_pagamento;
  }

  public void setMetodo_pagamento(String metodo_pagamento) {
    this.metodo_pagamento = metodo_pagamento;
  }

  public Integer getId_prodotto() {
    return id_prodotto;
  }

  public void setId_prodotto(Integer id_prodotto) {
    this.id_prodotto = id_prodotto;
  }

  public String getTaglia() {
    return taglia;
  }

  public void setTaglia(String taglia) {
    this.taglia = taglia;
  }

  public Integer getQuantita() {
    return quantita;
  }

  public void setQuantita(Integer quantita) {
    this.quantita = quantita;
  }



  
  

}
