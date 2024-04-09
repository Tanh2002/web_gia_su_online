package com.project.webgiasu.service;

import com.project.webgiasu.entity.Class;

import java.util.List;
import java.util.Optional;

public interface IClassService {
    List<Class> getAllClasses();

    Optional<Class> getClassById(Long classId);

    Class saveClass(Class classInfo);

    void deleteClassById(Long classId);
}
