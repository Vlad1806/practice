package com.mac.practice.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@NoArgsConstructor
public class VehicleEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "max_seats")
    private int maxSeats;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<JourneyEntity> journeys = new ArrayList<>();

    public void addJourney(final JourneyEntity journey){

        if (nonNull(journey)){
            journeys.add(journey);
        }
        journey.setVehicle(this);
    }

}
