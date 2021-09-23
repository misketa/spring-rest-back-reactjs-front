package com.OnlineStore.model.dto;

import com.OnlineStore.model.entity.ArtikalEntity;
import com.OnlineStore.model.entity.ProdavacEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class ProdavacDTO implements Serializable {


    private String email;
    private Date poslujeOd;
    private String adresa;
    private Boolean obrisan;
    private List<ArtikalEntity> artikli;

    public List<ArtikalEntity> getArtikli() {
        return artikli;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getPoslujeOd() {
        return poslujeOd;
    }

    public void setPoslujeOd(Date poslujeOd) {
        this.poslujeOd = poslujeOd;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Boolean getObrisan() {
        return obrisan;
    }

    public void setObrisan(Boolean obrisan) {
        this.obrisan = obrisan;
    }

    public void setArtikli(List<ArtikalEntity> artikli) {
        this.artikli = artikli;
    }
}
