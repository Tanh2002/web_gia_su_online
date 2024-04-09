package com.project.webgiasu.controller;

import com.project.webgiasu.service.IDistanceMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/distance-matrix")
public class DistanceMatrixController {

    private final IDistanceMatrixService distanceMatrixService;

    @Autowired
    public DistanceMatrixController(IDistanceMatrixService distanceMatrixService) {
        this.distanceMatrixService = distanceMatrixService;
    }

    @GetMapping("/distance")
    public Double getDistanceBetweenLocations(@RequestParam Long locationId1, @RequestParam Long locationId2) {
        return distanceMatrixService.getDistanceBetweenLocations(locationId1, locationId2);
    }
}

