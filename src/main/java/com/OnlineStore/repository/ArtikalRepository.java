package com.OnlineStore.repository;

import com.OnlineStore.model.entity.ArtikalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtikalRepository extends JpaRepository<ArtikalEntity, Long> {
}
