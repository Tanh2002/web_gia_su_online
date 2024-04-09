package com.project.webgiasu.controller;

import com.project.webgiasu.entity.Class;
import com.project.webgiasu.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    private final IClassService classService;

    @Autowired
    public ClassController(IClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    public ResponseEntity<List<Class>> getAllClasses() {
        List<Class> classes = classService.getAllClasses();
        return ResponseEntity.ok(classes);
    }

    @GetMapping("/{classId}")
    public ResponseEntity<Class> getClassById(@PathVariable Long classId) {
        Optional<Class> classOptional = classService.getClassById(classId);
        return classOptional.map(classInfo -> ResponseEntity.ok(classInfo))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Class> createClass(@RequestBody Class classInfo) {
        Class savedClass = classService.saveClass(classInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClass);
    }

    @DeleteMapping("/{classId}")
    public ResponseEntity<Void> deleteClassById(@PathVariable Long classId) {
        classService.deleteClassById(classId);
        return ResponseEntity.noContent().build();
    }
}
