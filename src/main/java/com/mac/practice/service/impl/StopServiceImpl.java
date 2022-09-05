package com.mac.practice.service.impl;

import com.mac.practice.mapper.StopMapper;
import com.mac.practice.model.dto.request.StopCreateRequestDto;
import com.mac.practice.model.dto.response.StopDto;
import com.mac.practice.model.entity.StopEntity;
import com.mac.practice.repository.jpa.StopEntityJPARepository;
import com.mac.practice.service.StopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StopServiceImpl implements StopService {

    private final StopEntityJPARepository stopEntityJPARepository;
    private final StopMapper stopMapper;


    @Override
    public StopDto getByID(Long stopId) {
        final Optional<StopEntity> byId = stopEntityJPARepository.findById(stopId);

        if (byId.isPresent()){
            final StopEntity stopEntity = byId.get();


            return stopMapper.getDto(stopEntity);
        }
        return null;
    }

    @Override
    public StopDto save(@RequestBody StopCreateRequestDto createRequestDto) {
        final StopEntity save = stopEntityJPARepository.save(stopMapper.getEntity(createRequestDto));
        return stopMapper.getDto(save);
    }
}
