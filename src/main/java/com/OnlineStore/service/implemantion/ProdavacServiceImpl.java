package com.OnlineStore.service.implemantion;


import com.OnlineStore.model.entity.ProdavacEntity;
import com.OnlineStore.model.role.Role;
import com.OnlineStore.model.role.RoleName;
import com.OnlineStore.payload.requests.RegistracijaRequest;
import com.OnlineStore.payload.responses.HttpResponse;
import com.OnlineStore.repository.ProdavacRepository;
import com.OnlineStore.repository.RoleRepository;
import com.OnlineStore.service.ProdavacService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ProdavacServiceImpl implements ProdavacService {
    private final ProdavacRepository prodavacRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public ProdavacServiceImpl(ProdavacRepository prodavacRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.prodavacRepository = prodavacRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public HttpResponse registracijaProdavac(RegistracijaRequest requestUser) {
        if (prodavacRepository.findByUserName(requestUser.getUsername()).isPresent()) {
            throw new RuntimeException("Credentials already taken!");
        }

        List<Role> roles = Collections.singletonList(roleRepository.findByName(RoleName.ROLE_PRODAVAC)
                .orElseThrow(() -> new RuntimeException("No role found!")));

        ProdavacEntity prodavacEntity = new ProdavacEntity();
        prodavacEntity.setIme(requestUser.getIme());
        prodavacEntity.setPrezime(requestUser.getPrezime());
        prodavacEntity.setUserName(requestUser.getUsername());
        prodavacEntity.setPassword(passwordEncoder.encode(requestUser.getPassword()));
        prodavacEntity.setRoles(roles);
        prodavacEntity.setAdresa(requestUser.getAdresa());
        prodavacEntity.setBlokiran(false);
        prodavacEntity.setEmail(requestUser.getEmail());
        prodavacEntity.setPoslujeOd(new Date());
        prodavacRepository.save(prodavacEntity);

        return new HttpResponse(Boolean.TRUE, "User registered successfully");
    }
}
