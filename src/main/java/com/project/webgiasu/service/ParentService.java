package com.project.webgiasu.service;

import com.project.webgiasu.entity.Parent;
import com.project.webgiasu.repository.IParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService implements IParentService {

    @Autowired
    private IParentRepository parentRepository;

    @Override
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    @Override
    public Optional<Parent> getParentById(Long parentId) {
        return parentRepository.findById(parentId);
    }

    @Override
    public Parent saveParent(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public void deleteParentById(Long parentId) {
        parentRepository.deleteById(parentId);
    }
}
