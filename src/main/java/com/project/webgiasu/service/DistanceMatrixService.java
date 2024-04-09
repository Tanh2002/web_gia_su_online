package com.project.webgiasu.service;

import com.project.webgiasu.repository.IDistanceMatrixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistanceMatrixService implements IDistanceMatrixService {

    @Autowired
    private IDistanceMatrixRepository distanceMatrixRepository;

    @Override
    public Double getDistanceBetweenLocations(Long locationId1, Long locationId2) {
        return distanceMatrixRepository.getDistance(locationId1, locationId2);
    }
}
