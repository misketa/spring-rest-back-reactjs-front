package com.OnlineStore.model.dto;

import com.OnlineStore.model.entity.KorisnikEntity;

import java.io.Serializable;

public class KorisnikDTO implements Serializable {

    private Long id;

    private String ime;

    private String prezime;

    private String username;

    private String password;

    public KorisnikDTO(KorisnikEntity korisnik){
        this.id = korisnik.getId();
        this.ime = korisnik.getIme();
        this.prezime = korisnik.getPrezime();
        this.username = korisnik.getUserName();
        this.password = korisnik.getPassword();
    }

    public KorisnikDTO() {
    }

    public KorisnikDTO(Long id, String ime, String prezime, String username, String password) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
