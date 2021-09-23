package com.OnlineStore.payload.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ArtikalPostRequest {

    @NotBlank
    @Size(min = 3, max = 50)
    private String naziv;

    @NotBlank
    @Size(max = 300)
    private String opis;

    @NotBlank
    private int cena;

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }

    public int getCena() {
        return cena;
    }
}

