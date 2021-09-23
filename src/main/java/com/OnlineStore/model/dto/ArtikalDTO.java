package com.OnlineStore.model.dto;

import java.io.Serializable;

public class ArtikalDTO implements Serializable {
    private String naziv;
    private String opis;
    private Integer cena;

    public ArtikalDTO() {
    }

    public ArtikalDTO(Long id) {
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }
}
