package com.OnlineStore.service;


import com.OnlineStore.payload.requests.RegistracijaRequest;
import com.OnlineStore.payload.responses.HttpResponse;

public interface ProdavacService {
    HttpResponse registracijaProdavac(RegistracijaRequest requestUser);

}
