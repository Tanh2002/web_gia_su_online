package com.project.webgiasu.controller;

import com.project.webgiasu.entity.Tutor;
import com.project.webgiasu.service.ITutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tutors")
public class TutorController {

    private final ITutorService tutorService;

    @Autowired
    public TutorController(ITutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping
    public ResponseEntity<List<Tutor>> getAllTutors() {
        List<Tutor> tutors = tutorService.getAllTutors();
        return ResponseEntity.ok(tutors);
    }

    @GetMapping("/{tutorId}")
    public ResponseEntity<Tutor> getTutorById(@PathVariable Long tutorId) {
        Optional<Tutor> tutorOptional = tutorService.getTutorById(tutorId);
        return tutorOptional.map(tutor -> ResponseEntity.ok(tutor))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tutor> createTutor(@RequestBody Tutor tutor) {
        Tutor savedTutor = tutorService.saveTutor(tutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTutor);
    }

    @DeleteMapping("/{tutorId}")
    public ResponseEntity<Void> deleteTutorById(@PathVariable Long tutorId) {
        tutorService.deleteTutorById(tutorId);
        return ResponseEntity.noContent().build();
    }
}

