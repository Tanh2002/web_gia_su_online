package com.project.webgiasu.repository;

import com.project.webgiasu.entity.DistanceMatrix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IDistanceMatrixRepository extends JpaRepository<DistanceMatrix, Long> {
    @Query("SELECT dm.distance_km FROM DistanceMatrix dm WHERE dm.location_id_1 = :locationId1 AND dm.location_id_2 = :locationId2")
    Double getDistance(@Param("locationId1") Long locationId1, @Param("locationId2") Long locationId2);
}
