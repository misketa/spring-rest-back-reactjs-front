package com.OnlineStore.payload.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegistracijaRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String ime;

    @NotBlank
    @Size(min = 2, max = 20)
    private String prezime;

    @NotBlank
    @Size(min = 4, max = 15)
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String adresa;

    @NotBlank
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
