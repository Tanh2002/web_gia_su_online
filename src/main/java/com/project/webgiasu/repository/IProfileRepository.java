package com.project.webgiasu.repository;

import com.project.webgiasu.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUserId(Long userId);
    void deleteByUserId(Long userId);
}
