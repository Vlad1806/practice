package com.mac.practice.repository.jpa;

import com.mac.practice.model.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleEntityJPARepository extends JpaRepository<VehicleEntity, Long> {

}