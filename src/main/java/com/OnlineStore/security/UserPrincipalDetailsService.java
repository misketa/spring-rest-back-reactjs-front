package com.OnlineStore.security;


import com.OnlineStore.model.entity.KorisnikEntity;
import com.OnlineStore.repository.KupacRepository;
import com.OnlineStore.repository.ProdavacRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserPrincipalDetailsService implements UserDetailsService{

    private final ProdavacRepository prodavacRepository;
    private final KupacRepository kupacRepository;


    public UserPrincipalDetailsService(ProdavacRepository prodavacRepository, KupacRepository kupacRepository) {
        this.prodavacRepository = prodavacRepository;
        this.kupacRepository = kupacRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) {
        KorisnikEntity korisnik;

        try {
            korisnik = prodavacRepository.findByUserName(username).get();
        }
        catch (Exception userException) {
            try {
                korisnik = kupacRepository.findByUserName(username).get();
            }
            catch (Exception adminException) {
                throw new UsernameNotFoundException("No user present with username : " + username);
            }
        }

        UserPrincipal userPrincipal = new UserPrincipal();
        userPrincipal.setId(korisnik.getId());
        userPrincipal.setIme(korisnik.getUserName());
        userPrincipal.setPrezime(korisnik.getPrezime());
        userPrincipal.setUserName(korisnik.getUserName());
        userPrincipal.setPassword(korisnik.getPassword());
        userPrincipal.setAuthorities(getAuthorities(korisnik));

        return userPrincipal;
    }

    private List<GrantedAuthority> getAuthorities(@NotNull KorisnikEntity korisnikEntity) {
        return korisnikEntity.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
    }

}
