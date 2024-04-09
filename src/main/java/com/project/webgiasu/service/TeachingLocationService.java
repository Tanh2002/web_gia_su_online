package com.project.webgiasu.service;

import com.project.webgiasu.entity.TeachingLocation;
import com.project.webgiasu.repository.ITeachingLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachingLocationService implements ITeachingLocationService {

    @Autowired
    private ITeachingLocationRepository teachingLocationRepository;

    @Override
    public List<TeachingLocation> getAllTeachingLocations() {
        return teachingLocationRepository.findAll();
    }

    @Override
    public TeachingLocation saveTeachingLocation(TeachingLocation teachingLocation) {
        return teachingLocationRepository.save(teachingLocation);
    }

    @Override
    public void deleteTeachingLocationById(Long locationId) {
        teachingLocationRepository.deleteById(locationId);
    }

    @Override
    public double getDistanceBetweenLocations(double lat1, double lon1, double lat2, double lon2) {
        // Chuyển đổi độ sang radian
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        // Bán kính Trái Đất
        final double earthRadius = 6371.0; // Đơn vị: kilometer

        // Tính toán khoảng cách giữa hai điểm sử dụng công thức haversine
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;

        return distance;
    }

}
