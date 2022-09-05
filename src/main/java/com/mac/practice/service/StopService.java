package com.mac.practice.service;

import com.mac.practice.model.dto.request.StopCreateRequestDto;
import com.mac.practice.model.dto.response.StopDto;

public interface StopService {

    StopDto getByID(Long stopId);

    StopDto save(StopCreateRequestDto createRequestDto);
}
