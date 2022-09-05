package com.mac.practice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StopDto {

    private Long id;
    private Double longitude;
    private Double latitude;
    private LocalDate dateBuild;
    private String city;
}
