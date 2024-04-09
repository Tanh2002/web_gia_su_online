package com.project.webgiasu.controller;

import com.project.webgiasu.entity.Parent;
import com.project.webgiasu.service.IParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parents")
public class ParentController {

    private final IParentService parentService;

    @Autowired
    public ParentController(IParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping
    public ResponseEntity<List<Parent>> getAllParents() {
        List<Parent> parents = parentService.getAllParents();
        return ResponseEntity.ok(parents);
    }

    @GetMapping("/{parentId}")
    public ResponseEntity<Parent> getParentById(@PathVariable Long parentId) {
        Optional<Parent> parentOptional = parentService.getParentById(parentId);
        return parentOptional.map(parent -> ResponseEntity.ok(parent))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Parent> createParent(@RequestBody Parent parent) {
        Parent savedParent = parentService.saveParent(parent);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedParent);
    }

    @DeleteMapping("/{parentId}")
    public ResponseEntity<Void> deleteParentById(@PathVariable Long parentId) {
        parentService.deleteParentById(parentId);
        return ResponseEntity.noContent().build();
    }
}

