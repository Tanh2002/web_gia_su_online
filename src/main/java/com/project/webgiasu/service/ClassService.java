package com.project.webgiasu.service;

import com.project.webgiasu.entity.Class;
import com.project.webgiasu.entity.Tutor;
import com.project.webgiasu.repository.IClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ClassService implements IClassService {

    @Autowired
    private IClassRepository classRepository;

    @Override
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    @Override
    public Optional<Class> getClassById(Long classId) {
        return classRepository.findById(classId);
    }

    @Override
    public Class saveClass(Class classInfo) {
        return classRepository.save(classInfo);
    }

    @Override
    public void deleteClassById(Long classId) {
        classRepository.deleteById(classId);
    }

}
