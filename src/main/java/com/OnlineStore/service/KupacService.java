package com.OnlineStore.service;

import com.OnlineStore.payload.requests.RegistracijaRequest;
import com.OnlineStore.payload.responses.HttpResponse;


public interface KupacService {
    HttpResponse registracijaKorisnika(RegistracijaRequest requestUser);

}
