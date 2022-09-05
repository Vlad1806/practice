package com.mac.practice.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "journey")
public class JourneyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "station_from")
    private String stationFrom;

    @Column(name = "station_to", nullable = false)
    private String stationTo;

    @Column(name = "departure", nullable = false)
    private Instant departure;

    @Column(name = "arrival", nullable = false)
    private Instant arrival;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicle;

    @ManyToMany
    @JoinTable(name = "journey_stop",
            joinColumns = @JoinColumn(name = "journey_id"),
            inverseJoinColumns = @JoinColumn(name = "stop_id")
    )
    private List<StopEntity> stops = new ArrayList<>();


    public void addStop(final StopEntity stopEntity){

        if (nonNull(stopEntity)) {
            stops.add(stopEntity);

        }
    }

    public void addVehicle(final VehicleEntity vehicle){
        this.vehicle = vehicle;
        vehicle.addJourney(this);
    }
}
