package com.OnlineStore.service;

import com.OnlineStore.model.entity.KorisnikEntity;

public interface KorisnikService {

    KorisnikEntity findByUserName(String userName);
}
