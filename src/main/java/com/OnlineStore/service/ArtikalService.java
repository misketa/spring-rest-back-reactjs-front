package com.OnlineStore.service;

import com.OnlineStore.model.dto.ArtikalDTO;
import com.OnlineStore.model.entity.ArtikalEntity;
import com.OnlineStore.payload.requests.ArtikalPostRequest;
import com.OnlineStore.security.UserPrincipal;

import java.util.List;

public interface ArtikalService {

    ArtikalEntity findOne(Long artikalId);
    List<ArtikalEntity> findAll();
    ArtikalEntity save(ArtikalDTO artikalDTO/*, UserPrincipal userPrincipal*/);
    void remove (Long id);
    ArtikalEntity update(Long id, ArtikalPostRequest artikalPostRequest/*, UserPrincipal currentUser*/);

}
