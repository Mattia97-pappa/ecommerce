# 🛍️ Negozio di Abbigliamento Online 👕






## 🚀 Come Iniziare

1. Clona il repository:
   bash
   git clone https://github.com/Mattia97-pappa/ecommerce.git


👀 Il codice sorgente completo si trova in src, suddiviso in package chiari:

controller → gestione delle rotte

entity → entità del database

repository → interfaccia con il DB

security & config → login, autenticazione e accessi

Esegui la classe Application.java (o simile, con @SpringBootApplication) per avviare l'app




Tabelle da copiare e incollare per far funzionare il sistema. 
Per accedere come amministratore dovete creare un record account dal database(tabella admuser).



```Tabelle user
CREATE TABLE `admuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

```
``` Tabella ordini
CREATE TABLE `ordini` (
  `id_ordine` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `data_ordine` date NOT NULL,
  `importo` int(11) DEFAULT NULL,
  `metodo_pagamento` varchar(255) DEFAULT NULL,
  `id_prodotto` int(11) DEFAULT NULL,
  `taglia` varchar(255) DEFAULT NULL,
  `quantita` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_ordine`),
  KEY `id_cliente` (`id_cliente`),
  KEY `fk_prodotto` (`id_prodotto`),
  CONSTRAINT `fk_prodotto` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotti` (`id_prodotto`),
  CONSTRAINT `ordini_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
```
``` Tabella prodotti
CREATE TABLE `prodotti` (
  `id_prodotto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  `prezzo` varchar(255) DEFAULT NULL,
  `immagine_url` varchar(255) DEFAULT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_prodotto`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
```
``` Tabella user
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cognome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `citta` varchar(255) NOT NULL,
  `indirizzo` varchar(255) DEFAULT NULL,
  `cap` int(11) DEFAULT NULL,
  `registrazione` date DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

```





Applicazione web full-stack per un negozio di abbigliamento online, sviluppata in **Java**.

✨ Funzionalità

- Autenticazione utenti
- Navigazione dei prodotti
- Creazione e gestione ordini
- Persistenza dei dati
- Gestione completa (CRUD) da parte dell'amministratore per i dati e le risorse dell'applicazione

#🛠️ Tecnologie Utilizzate

- Java
- Spring Framework
- Spring Security
- JPA (Hibernate)
- Bootstrap
- JavaScript





 🎥 Demo Videos


  [User](https://vimeo.com/1075993637)

 
  [Admin](https://vimeo.com/1076027145)


