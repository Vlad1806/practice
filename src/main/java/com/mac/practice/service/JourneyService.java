package com.mac.practice.service;

import com.mac.practice.model.dto.request.JourneyCreateRequestDto;
import com.mac.practice.model.dto.response.JourneyDto;

public interface JourneyService {

    JourneyDto getByID(Long id);

    JourneyDto save(JourneyCreateRequestDto createRequestDto);
}
