package com.mac.practice.service;

import com.mac.practice.model.dto.request.VehicleCreateRequestDto;
import com.mac.practice.model.dto.response.VehicleDto;

public interface VehicleService {

    VehicleDto getByID(Long id);

    VehicleDto save(VehicleCreateRequestDto createRequestDto);
}
