package com.mac.practice.controller;

import com.mac.practice.model.dto.common.ResponseDto;
import com.mac.practice.model.dto.request.JourneyCreateRequestDto;
import com.mac.practice.model.dto.response.JourneyDto;
import com.mac.practice.service.JourneyService;
import com.mac.practice.util.factory.ResponseDtoFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JourneyController {

    private final JourneyService journeyServiceImpl;

    @GetMapping(value = "/journey/{id}")
    public ResponseEntity<ResponseDto<JourneyDto>> getJourneyByID(@PathVariable("id") Long id) {

        return ResponseEntity.ok(ResponseDtoFactory.getSuccessfulResponseDto(journeyServiceImpl.getByID(id)));
    }

    @PostMapping(value = "/journey")
    public ResponseEntity<ResponseDto<JourneyDto>> saveJourney(@RequestBody JourneyCreateRequestDto createRequestDto) {
        return ResponseEntity.ok(ResponseDtoFactory.getSuccessfulResponseDto(journeyServiceImpl.save(createRequestDto)));
    }
}
