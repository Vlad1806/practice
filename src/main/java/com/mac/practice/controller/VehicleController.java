package com.mac.practice.controller;

import com.mac.practice.model.dto.common.ResponseDto;
import com.mac.practice.model.enums.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Collections.emptyList;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VehicleController {

    @GetMapping
    public ResponseEntity<ResponseDto<Boolean>> getVehicleByID() {

        return ResponseEntity.ok(ResponseDto.<Boolean>builder()
                .status(Status.OK)
                .data(true)
                .errors(emptyList())
                .build());
    }
}
