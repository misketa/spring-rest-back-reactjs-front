package com.OnlineStore.model.entity;

import com.OnlineStore.model.role.Role;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class KorisnikEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id",unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(name = "ime", nullable = false)
    private String ime;

    @Column(name = "prezime", nullable = false)
    private String prezime;

    @Column(name = "username", unique = false, nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "blokiran", nullable = false)
    private Boolean blokiran;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    public List<Role> getRoles() {
        if (roles == null) {
            return null;
        }

        return new ArrayList<>(roles);
    }

    public void setRoles(List<Role> roles) {
        if (roles == null) {
            this.roles = null;
        } else {
            this.roles = Collections.unmodifiableList(roles);
        }
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getIme() {
        return ime;
    }

    public Long getId() {
        return id;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getBlokiran() {
        return blokiran;
    }

    public void setBlokiran(Boolean blokiran) {
        this.blokiran = blokiran;
    }
}

