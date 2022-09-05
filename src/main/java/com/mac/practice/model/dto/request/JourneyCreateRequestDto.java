package com.mac.practice.model.dto.request;

import com.mac.practice.model.entity.StopEntity;
import com.mac.practice.model.entity.VehicleEntity;
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
public class JourneyCreateRequestDto {

    private String stationFrom;
    private String stationTo;
    private Instant departure;
    private Instant arrival;
    private Long vehicleId;
    private List<Long> stopIds;
}
