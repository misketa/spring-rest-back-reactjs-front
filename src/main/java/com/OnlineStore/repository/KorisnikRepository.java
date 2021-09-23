package com.OnlineStore.repository;

import com.OnlineStore.model.entity.KorisnikEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KorisnikRepository extends JpaRepository<KorisnikEntity, Integer> {

    Optional<KorisnikEntity> findFirstByUserName(String userName);
}
