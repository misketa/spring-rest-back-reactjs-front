package com.OnlineStore.repository;

import com.OnlineStore.model.entity.KupacEntity;
import com.OnlineStore.model.entity.ProdavacEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KupacRepository extends JpaRepository<KupacEntity, Long> {
    Optional<KupacEntity> findByUserName(String userName);
}
