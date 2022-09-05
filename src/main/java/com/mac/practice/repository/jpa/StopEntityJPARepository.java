package com.mac.practice.repository.jpa;

import com.mac.practice.model.entity.StopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StopEntityJPARepository extends JpaRepository<StopEntity, Long> {
}