package com.OnlineStore.bootstrap;


import com.OnlineStore.model.entity.ArtikalEntity;
import com.OnlineStore.model.entity.ProdavacEntity;
import com.OnlineStore.model.role.Role;
import com.OnlineStore.model.role.RoleName;
import com.OnlineStore.repository.ArtikalRepository;
import com.OnlineStore.repository.ProdavacRepository;
import com.OnlineStore.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

@Profile({"default", "test"})
@Component
public class DataLoader implements CommandLineRunner {

    private final ArtikalRepository artikalRepository;
    private final ProdavacRepository prodavacRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public DataLoader(ArtikalRepository artikalRepository,  ProdavacRepository prodavacRepository,
                      PasswordEncoder passwordEncoder, RoleRepository roleRepository){
        this.artikalRepository = artikalRepository;
        this.passwordEncoder = passwordEncoder;
        this.prodavacRepository = prodavacRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        Role adminRole = new Role(RoleName.ROLE_ADMIN);
        Role prodavacRole = new Role(RoleName.ROLE_PRODAVAC);
        Role kupacRole = new Role(RoleName.ROLE_KUPAC);

        roleRepository.saveAll(Arrays.asList(adminRole, prodavacRole, kupacRole));

        Role role = roleRepository.findByName(RoleName.ROLE_PRODAVAC).orElseThrow(() -> new RuntimeException("No Role found"));

        ProdavacEntity prodavacEntity = new ProdavacEntity();
        prodavacEntity.setIme("Marko");
        prodavacEntity.setPrezime("Markovic");
        prodavacEntity.setUserName("mare");
        prodavacEntity.setPassword(passwordEncoder.encode("777"));
        prodavacEntity.setAdresa("Sabac");
        prodavacEntity.setEmail("mare@gmail.com");
        prodavacEntity.setPoslujeOd(new Date());
        prodavacEntity.setRoles(Collections.singletonList(role));
        prodavacEntity.setBlokiran(false);

        ProdavacEntity prodavac = prodavacRepository.save(prodavacEntity);

        ArtikalEntity artikalEntity = new ArtikalEntity("Secer", "Podravka secer",250, prodavac);

        artikalRepository.save(artikalEntity);




    }


}
