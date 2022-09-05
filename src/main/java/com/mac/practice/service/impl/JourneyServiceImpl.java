package com.mac.practice.service.impl;

import com.mac.practice.mapper.JourneyMapper;
import com.mac.practice.model.dto.request.JourneyCreateRequestDto;
import com.mac.practice.model.dto.response.JourneyDto;
import com.mac.practice.model.entity.JourneyEntity;
import com.mac.practice.model.entity.StopEntity;
import com.mac.practice.repository.jpa.JourneyEntityJPARepository;
import com.mac.practice.service.JourneyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class JourneyServiceImpl implements JourneyService {

    private final JourneyEntityJPARepository journeyRepository;
    private final JourneyMapper journeyMapper;

    @Override
    public JourneyDto getByID(Long id) {
        final Optional<JourneyEntity> byId = journeyRepository.findById(id);

        if (byId.isPresent()) {
            final JourneyEntity stopEntity = byId.get();


            return journeyMapper.getDto(stopEntity);
        }
        return null;
    }

    @Override
    public JourneyDto save(JourneyCreateRequestDto createRequestDto) {

        final JourneyEntity entity = journeyMapper.getEntity(createRequestDto);
        final JourneyEntity save = journeyRepository.save(entity);
        return journeyMapper.getDto(save);
    }
}
