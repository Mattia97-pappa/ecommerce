package com.example.sitoweb.entity;



import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {


@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "username")
  private String username;

  @Column(name = "nome")
  private String nome;

  @Column(name = "cognome")
  private String cognome;

  @Column(name = "email")
  private String email;

  @Column(name = "telefono")
  private String telefono;

  @Column(name = "citta")
  private String citta;

  @Column(name = "indirizzo")
  private String indirizzo;

  @Column(name = "cap")
  private Integer cap;

  @Column(name = "registrazione")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate registrazione;

  @Column(name = "password")
  private String password;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getCitta() {
    return citta;
  }

  public void setCitta(String citta) {
    this.citta = citta;
  }

  public String getIndirizzo() {
    return indirizzo;
  }

  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }

  public Integer getCap() {
    return cap;
  }

  public void setCap(Integer cap) {
    this.cap = cap;
  }

  public LocalDate getRegistrazione() {
    return registrazione;
  }

  public void setRegistrazione(LocalDate registrazione) {
    this.registrazione = registrazione;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  

  
  
  
}