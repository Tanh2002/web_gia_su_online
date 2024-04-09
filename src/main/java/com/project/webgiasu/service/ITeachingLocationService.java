package com.project.webgiasu.service;

import com.project.webgiasu.entity.TeachingLocation;

import java.util.List;

public interface ITeachingLocationService {
    List<TeachingLocation> getAllTeachingLocations();

    TeachingLocation saveTeachingLocation(TeachingLocation teachingLocation);

    void deleteTeachingLocationById(Long locationId);

    double getDistanceBetweenLocations(double lat1, double lon1, double lat2, double lon2);
}
