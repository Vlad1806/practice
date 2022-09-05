package com.mac.practice.model.entity;

import com.mac.practice.util.factory.convertors.YesNoConvector;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static java.util.Objects.isNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "vehicle_seat")
public class VehicleSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "journey_id", nullable = false)
    private JourneyEntity journey;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private VehicleEntity vehicle;

    @Column(name = "seat_number", nullable = false)
    private Integer seatNumber;

    @Column(name = "booked", nullable = false)
    @Convert(converter = YesNoConvector.class)
    private boolean booked;

    public void addVehicle(final VehicleEntity vehicle) {

        if (isNull(vehicle)) throw new IllegalArgumentException("Vehicle must be set!");
        this.vehicle = vehicle;
    }

    public void addJourney(final JourneyEntity journey) {

        if (isNull(journey)) throw new IllegalArgumentException("Journey must be set!");
        this.journey = journey;
    }

    public void removeAllJourneys(){
        journey = null;
    }

    public void removeAllVehicles(){
        vehicle = null;
    }
}
