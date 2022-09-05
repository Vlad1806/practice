package com.mac.practice.controller;

import com.mac.practice.model.dto.common.ResponseDto;
import com.mac.practice.model.dto.request.VehicleCreateRequestDto;
import com.mac.practice.model.dto.response.VehicleDto;
import com.mac.practice.service.VehicleService;
import com.mac.practice.util.factory.ResponseDtoFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleServiceImpl;

    @GetMapping(value = "/vehicle/{id}")
    public ResponseEntity<ResponseDto<VehicleDto>> getVehicleByID(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ResponseDtoFactory.getSuccessfulResponseDto(vehicleServiceImpl.getByID(id)));
    }


    @PostMapping(value = "/vehicle")
    public ResponseEntity<ResponseDto<VehicleDto>> saveVehicle(@RequestBody VehicleCreateRequestDto createRequestDto) {
        return ResponseEntity.ok(ResponseDtoFactory.getSuccessfulResponseDto(vehicleServiceImpl.save(createRequestDto)));
    }
}
