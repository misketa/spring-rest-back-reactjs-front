package com.OnlineStore.model.entity;

import antlr.build.ANTLR;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "prodavci")
public class ProdavacEntity extends KorisnikEntity{

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "poslujeOd", unique = false, nullable = false)
    private Date poslujeOd;

    @Column(name = "adresa", unique = false, nullable = false)
    private String adresa;

    @OneToMany(mappedBy = "prodavacEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArtikalEntity> artikli = new ArrayList<>();

    public ProdavacEntity() {
    }

    public ProdavacEntity(String email, Date poslujeOd, String adresa, List<ArtikalEntity> artikli) {
        this.email = email;
        this.poslujeOd = poslujeOd;
        this.adresa = adresa;
        this.artikli = artikli;
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

    public List<ArtikalEntity> getArtikli() {
        return artikli;
    }

    public void setArtikli(List<ArtikalEntity> artikli) {
        this.artikli = artikli;
    }
}
