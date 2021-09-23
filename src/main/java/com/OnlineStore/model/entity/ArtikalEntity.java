package com.OnlineStore.model.entity;




import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "artikli")
public class ArtikalEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artikal_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "naziv", unique = false, nullable = false)
    private String naziv;

    @Column(name = "opis", unique = false, nullable = false)
    private String opis;

    @Column(name = "cena", unique = false, nullable = false)
    private Integer cena;

    @ManyToOne
    @JoinColumn(name = "prodavac_id")
    @JsonIgnore
    private ProdavacEntity prodavacEntity;

    public ArtikalEntity() {
    }

    public ArtikalEntity(String naziv, String opis, Integer cena, ProdavacEntity prodavacEntity) {
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
        this.prodavacEntity = prodavacEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ProdavacEntity getProdavacEntity() {
        return prodavacEntity;
    }

    public void setProdavacEntity(ProdavacEntity prodavacEntity) {
        this.prodavacEntity = prodavacEntity;
    }
}
