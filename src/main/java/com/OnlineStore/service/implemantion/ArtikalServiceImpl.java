package com.OnlineStore.service.implemantion;

import com.OnlineStore.Exeptions.ResourceNotFoundException;
import com.OnlineStore.model.dto.ArtikalDTO;
import com.OnlineStore.model.entity.ArtikalEntity;
import com.OnlineStore.model.entity.ProdavacEntity;
import com.OnlineStore.payload.requests.ArtikalPostRequest;
import com.OnlineStore.payload.responses.HttpResponse;
import com.OnlineStore.repository.ArtikalRepository;
import com.OnlineStore.repository.ProdavacRepository;
import com.OnlineStore.security.UserPrincipal;
import com.OnlineStore.service.ArtikalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.OnlineStore.utils.ApplicationUtilities.isUserProdavac;

@Slf4j

@Service
public class ArtikalServiceImpl implements ArtikalService {


    private final ArtikalRepository artikalRepository;
    private final ProdavacRepository prodavacRepository;

    public ArtikalServiceImpl(ArtikalRepository artikalRepository,  ProdavacRepository prodavacRepository){
        this.artikalRepository = artikalRepository;
        this.prodavacRepository = prodavacRepository;
    }


    @Override
    public ArtikalEntity findOne(Long artikalId) {
        return artikalRepository.findById(artikalId).orElse(null);
    }

    @Override
    public List<ArtikalEntity> findAll() {
        return artikalRepository.findAll();
    }

    @Override
    public ArtikalEntity save(ArtikalDTO artikalDTO/*, UserPrincipal userPrincipal*/) {

        /*ProdavacEntity prodavac = prodavacRepository.findById(userPrincipal.getId()).orElseThrow(
                () -> new RuntimeException("User not found"));*/
        ArtikalEntity artikal = new ArtikalEntity();
        artikal.setNaziv(artikalDTO.getNaziv());
        artikal.setOpis(artikalDTO.getOpis());
        artikal.setCena(artikalDTO.getCena());
        //.setProdavacEntity(prodavac);

        return artikalRepository.save(artikal);
    }

    @Override
    public void remove(Long id) {artikalRepository.deleteById(id); }

    @Override
    public ArtikalEntity update(Long id, ArtikalPostRequest artikalPostRequest/*, UserPrincipal currentUser*/) {
        ArtikalEntity artikalEntity = artikalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Book with id " + id + " not found"));


        //if (artikalEntity.getProdavacEntity().getId().equals(currentUser.getId())) {

            artikalEntity.setNaziv(artikalPostRequest.getNaziv());
            artikalEntity.setCena(artikalPostRequest.getCena());
            artikalEntity.setOpis(artikalPostRequest.getOpis());

            return artikalRepository.save(artikalEntity);
        //}

        //HttpResponse response = new HttpResponse(Boolean.FALSE, "You don't have permission to update book");

        //throw new RuntimeException(response.getMessage());
    }

}
