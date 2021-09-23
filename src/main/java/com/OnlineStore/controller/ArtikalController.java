package com.OnlineStore.controller;


import com.OnlineStore.Exeptions.ArtikalNotFoundExeption;
import com.OnlineStore.model.dto.ArtikalDTO;
import com.OnlineStore.model.entity.ArtikalEntity;
import com.OnlineStore.payload.requests.ArtikalPostRequest;
import com.OnlineStore.repository.ArtikalRepository;
import com.OnlineStore.security.UserPrincipal;
import com.OnlineStore.service.ArtikalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/artikli")
@CrossOrigin(origins = "http://localhost:3000")
public class ArtikalController {

    private final ArtikalRepository artikalRepository;

    private final ArtikalService artikalService;

    ArtikalController(ArtikalRepository artikalRepository, ArtikalService artikalService) {
        this.artikalRepository = artikalRepository;
        this.artikalService = artikalService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ArtikalEntity> findOne(@PathVariable Long id) {
        ArtikalEntity artikal = artikalRepository.findById(id)
                .orElseThrow(() -> new ArtikalNotFoundExeption("Artikal sa datim id ne postoji"));

        return new ResponseEntity<>(artikal, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<ArtikalEntity>> findAll() {
        List<ArtikalEntity> artikli = artikalService.findAll();
        return new ResponseEntity<>(artikli, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ArtikalEntity> save(@Valid @RequestBody ArtikalDTO artikalDTO
                                              /*@AuthenticationPrincipal UserPrincipal userPrincipal*/) {
        ArtikalEntity artikalEntity = artikalService.save(artikalDTO/*, userPrincipal*/);
        return new ResponseEntity<>(artikalEntity, HttpStatus.CREATED);

    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ArtikalEntity> update(@PathVariable("id") Long id,
                                                @Valid @RequestBody ArtikalPostRequest artikalPostRequest
                                               /* @AuthenticationPrincipal UserPrincipal currentUser*/) {
        ArtikalEntity update = artikalService.update(id, artikalPostRequest/*, currentUser*/);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteArtikal(@PathVariable Long id) {

        artikalRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
