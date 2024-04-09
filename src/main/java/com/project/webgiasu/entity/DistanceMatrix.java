package com.project.webgiasu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "distance_matrix")
@Getter
@Setter
public class DistanceMatrix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id_1")
    private TeachingLocation location1;

    @ManyToOne
    @JoinColumn(name = "location_id_2")
    private TeachingLocation location2;

    private BigDecimal distanceKm;

}
