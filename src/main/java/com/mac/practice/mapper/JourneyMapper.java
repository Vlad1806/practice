package com.mac.practice.mapper;

import com.mac.practice.model.dto.request.JourneyCreateRequestDto;
import com.mac.practice.model.dto.response.JourneyDto;
import com.mac.practice.model.entity.JourneyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {StopMapper.class, VehicleMapper.class})
public interface JourneyMapper {

    @Mapping(target = "vehicle.id", source = "vehicleId")
    @Mapping(target = "stops", source = "stopIds", qualifiedByName = "longToStopEntity")
    JourneyEntity getEntity(JourneyCreateRequestDto dto);

    JourneyDto getDto(JourneyEntity entity);

    JourneyEntity getDto(JourneyDto dto);
}
