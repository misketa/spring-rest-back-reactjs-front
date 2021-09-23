package com.OnlineStore.service.implemantion;

import com.OnlineStore.model.entity.KupacEntity;
import com.OnlineStore.model.role.Role;
import com.OnlineStore.model.role.RoleName;
import com.OnlineStore.repository.KupacRepository;
import com.OnlineStore.repository.RoleRepository;
import com.OnlineStore.payload.requests.RegistracijaRequest;
import com.OnlineStore.payload.responses.HttpResponse;
import com.OnlineStore.service.KupacService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;



@Service
public class KupacServiceImpl implements KupacService {

    private final KupacRepository kupacRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public KupacServiceImpl( KupacRepository kupacRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.kupacRepository = kupacRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public HttpResponse registracijaKorisnika(RegistracijaRequest requestUser) {
        if (kupacRepository.findByUserName(requestUser.getUsername()).isPresent()) {
            throw new RuntimeException("Credentials already taken!");
        }

        List<Role> roles = Collections.singletonList(roleRepository.findByName(RoleName.ROLE_KUPAC)
                .orElseThrow(() -> new RuntimeException("No role found!")));

        KupacEntity kupacEntity = new KupacEntity();
        kupacEntity.setIme(requestUser.getIme());
        kupacEntity.setPrezime(requestUser.getPrezime());
        kupacEntity.setUserName(requestUser.getUsername());
        kupacEntity.setPassword(passwordEncoder.encode(requestUser.getPassword()));
        kupacEntity.setRoles(roles);
        kupacEntity.setAdresa(requestUser.getAdresa());
        kupacEntity.setBlokiran(false);
        kupacRepository.save(kupacEntity);

        return new HttpResponse(Boolean.TRUE, "User registered successfully");
    }


}
