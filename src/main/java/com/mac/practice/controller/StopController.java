package com.mac.practice.controller;

import com.mac.practice.model.dto.common.ResponseDto;
import com.mac.practice.model.dto.request.StopCreateRequestDto;
import com.mac.practice.model.dto.response.StopDto;
import com.mac.practice.service.StopService;
import com.mac.practice.util.factory.ResponseDtoFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StopController {

    private final StopService stopServiceImpl;

    @GetMapping(value = "/stop/{id}")
    public ResponseEntity<ResponseDto<StopDto>> getStopByID(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ResponseDtoFactory.getSuccessfulResponseDto(stopServiceImpl.getByID(id)));
    }

    @PostMapping(value = "/stop")
    public ResponseEntity<ResponseDto<StopDto>> saveStop(@RequestBody StopCreateRequestDto createRequestDto) {
        return ResponseEntity.ok(ResponseDtoFactory.getSuccessfulResponseDto(stopServiceImpl.save(createRequestDto)));
    }
}
