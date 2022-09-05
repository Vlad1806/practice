package com.mac.practice.service.impl;

import com.mac.practice.mapper.VehicleMapper;
import com.mac.practice.model.dto.request.VehicleCreateRequestDto;
import com.mac.practice.model.dto.response.VehicleDto;
import com.mac.practice.model.entity.VehicleEntity;
import com.mac.practice.repository.jpa.VehicleEntityJPARepository;
import com.mac.practice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleEntityJPARepository vehicleEntityJPARepository;
    private final VehicleMapper vehicleMapper;

    @Override
    public VehicleDto getByID(Long id) {

        final Optional<VehicleEntity> byId = vehicleEntityJPARepository.findById(id);

        return vehicleMapper.getDto(byId.orElseThrow(() -> new IllegalStateException("Can not found vehicle with id" + id)));
    }

    @Override
    public VehicleDto save(VehicleCreateRequestDto createRequestDto) {
        return vehicleMapper.getDto(vehicleEntityJPARepository.save(vehicleMapper.getEntity(createRequestDto)));
    }
}
