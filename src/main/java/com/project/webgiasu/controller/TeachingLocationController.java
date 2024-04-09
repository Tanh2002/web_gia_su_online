package com.project.webgiasu.controller;

import com.project.webgiasu.entity.TeachingLocation;
import com.project.webgiasu.service.ITeachingLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teaching-locations")
public class TeachingLocationController {

    private final ITeachingLocationService teachingLocationService;

    @Autowired
    public TeachingLocationController(ITeachingLocationService teachingLocationService) {
        this.teachingLocationService = teachingLocationService;
    }

    @GetMapping
    public ResponseEntity<List<TeachingLocation>> getAllTeachingLocations() {
        List<TeachingLocation> teachingLocations = teachingLocationService.getAllTeachingLocations();
        return ResponseEntity.ok(teachingLocations);
    }

    @PostMapping
    public ResponseEntity<TeachingLocation> createTeachingLocation(@RequestBody TeachingLocation teachingLocation) {
        TeachingLocation savedTeachingLocation = teachingLocationService.saveTeachingLocation(teachingLocation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTeachingLocation);
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<Void> deleteTeachingLocationById(@PathVariable Long locationId) {
        teachingLocationService.deleteTeachingLocationById(locationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/distance")
    public double getDistanceBetweenLocations(@RequestParam double lat1, @RequestParam double lon1,
                                              @RequestParam double lat2, @RequestParam double lon2) {
        return teachingLocationService.getDistanceBetweenLocations(lat1, lon1, lat2, lon2);
    }
}

