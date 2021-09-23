package com.OnlineStore.repository;

import com.OnlineStore.model.entity.ProdavacEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdavacRepository extends JpaRepository<ProdavacEntity, Long> {
    Optional<ProdavacEntity> findByUserName(String userName);
}
