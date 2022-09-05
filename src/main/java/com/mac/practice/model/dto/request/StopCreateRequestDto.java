package com.mac.practice.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StopCreateRequestDto {

    private Double longitude;
    private Double latitude;
    private LocalDate dateBuild;
    private String city;
}
