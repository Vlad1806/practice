package com.mac.practice.mapper;

import com.mac.practice.model.dto.request.StopCreateRequestDto;
import com.mac.practice.model.dto.response.StopDto;
import com.mac.practice.model.entity.StopEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
public interface StopMapper {

    StopEntity getEntity(StopCreateRequestDto dto);

    StopDto getDto(StopEntity entity);

    StopEntity getDto(StopDto dto);

    @Named("longToStopEntity")
    static StopEntity longToStopEntity(Long id){
        final StopEntity stopEntity = new StopEntity();
        stopEntity.setId(id);
        return stopEntity;
    }
}
