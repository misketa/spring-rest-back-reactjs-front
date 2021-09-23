package com.OnlineStore.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "kupci")
public class KupacEntity extends KorisnikEntity {

    @Column(name = "adresa", nullable = false)
    private String adresa;

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getAdresa() {
        return adresa;
    }
}
