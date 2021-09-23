package com.OnlineStore.service.implemantion;

import com.OnlineStore.model.entity.KorisnikEntity;
import com.OnlineStore.repository.KorisnikRepository;
import com.OnlineStore.service.KorisnikService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;

    public KorisnikServiceImpl (KorisnikRepository korisnikRepository){
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public KorisnikEntity findByUserName(String userName) {
        Optional<KorisnikEntity> user = korisnikRepository.findFirstByUserName(userName);
        if (!user.isEmpty()) {
            return user.get();
        }
        return null;
    }
}
