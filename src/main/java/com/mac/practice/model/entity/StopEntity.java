package com.mac.practice.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "stop")
public class StopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "longitude",nullable = false)
    private Double longitude;

    @Column(name = "latitude",nullable = false)
    private Double latitude;

    @Column(name = "date_build")
    private LocalDate dateBuild;

    @Column(name = "city")
    private String city;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "journey_stop",
            joinColumns = @JoinColumn(name = "stop_id"),
            inverseJoinColumns = @JoinColumn(name = "journey_id")
    )
    private List<JourneyEntity> journey = new ArrayList<>();

    public void addJourney(final JourneyEntity journeyEntity){

        if (nonNull(journeyEntity)) {

            journey.add(journeyEntity);
            journeyEntity.addStop(this);
        }
    }
}
