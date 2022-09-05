package com.mac.practice.repository.jpa;

import com.mac.practice.model.entity.JourneyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JourneyEntityJPARepository extends JpaRepository<JourneyEntity, Long> {
}