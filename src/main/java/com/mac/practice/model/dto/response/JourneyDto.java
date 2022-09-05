package com.mac.practice.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JourneyDto {

    private Long id;
    private String stationFrom;
    private String stationTo;
    private Instant departure;
    private Instant arrival;
    private VehicleDto vehicle;
    private List<StopDto> stops;
}
