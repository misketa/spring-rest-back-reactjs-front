package com.OnlineStore.controller;

import com.OnlineStore.model.dto.KorisnikDTO;
import com.OnlineStore.model.entity.KorisnikEntity;
import com.OnlineStore.payload.requests.RegistracijaRequest;
import com.OnlineStore.payload.responses.HttpResponse;
import com.OnlineStore.service.KorisnikService;
import com.OnlineStore.service.KupacService;
import com.OnlineStore.service.ProdavacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    //@Autowired
    //KorisnikService korisnikService;

    private final KupacService kupacService;
    private final ProdavacService prodavacService;
    private final KorisnikService korisnikService;

    public AuthController(KupacService kupacService, ProdavacService prodavacService, KorisnikService korisnikService){
        this.kupacService = kupacService;
        this.prodavacService = prodavacService;
        this.korisnikService = korisnikService;
    }

    @PostMapping("/prijava")
    public ResponseEntity<String> prijava(@RequestBody KorisnikDTO userDto) {
        KorisnikEntity k = korisnikService.findByUserName(userDto.getUsername());
        if (k == null) {
            return ResponseEntity.notFound().build();
        }


        /*UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getUsername());
            return ResponseEntity.ok(tokenUtils.generateToken(userDetails));
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.notFound().build();
        }*/
        return ResponseEntity.ok().build();

    }

    @PostMapping("/registracija1")
    public ResponseEntity<HttpResponse> registracijaKorisnika(@Valid @RequestBody RegistracijaRequest requestUser) {
        HttpResponse response = kupacService.registracijaKorisnika(requestUser);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/register")
    public ResponseEntity<HttpResponse> registracijaProdavca(@Valid @RequestBody RegistracijaRequest requestUser) {
        HttpResponse response = prodavacService.registracijaProdavac(requestUser);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
