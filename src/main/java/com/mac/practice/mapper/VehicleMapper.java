package com.mac.practice.mapper;

import com.mac.practice.model.dto.request.VehicleCreateRequestDto;
import com.mac.practice.model.dto.response.VehicleDto;
import com.mac.practice.model.entity.VehicleEntity;
import org.mapstruct.Mapper;

@Mapper
public interface VehicleMapper {

    VehicleEntity getEntity(VehicleCreateRequestDto dto);

    VehicleDto getDto(VehicleEntity entity);

    VehicleEntity getDto(VehicleDto dto);
}
