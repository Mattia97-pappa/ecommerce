package com.example.sitoweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prodotti")
public class Prodotti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prodotto")
    private Integer id;

@Column(name = "nome")
  private String nome;

  @Column(name = "descrizione")
  private String descrizione;

  @Column(name = "prezzo")
  private String prezzo;

  @Column(name = "immagine_url")
  private String immagineUrl;

  @Column(name = "categoria")
  private String categoria;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getPrezzo() {
    return prezzo;
  }

  public void setPrezzo(String prezzo) {
    this.prezzo = prezzo;
  }

  public String getImmagineUrl() {
    return immagineUrl;
  }

  public void setImmagineUrl(String immagineUrl) {
    this.immagineUrl = immagineUrl;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  
}
