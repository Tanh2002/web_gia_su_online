package com.project.webgiasu.service;

import com.project.webgiasu.entity.Profile;

import java.util.Optional;

public interface IProfileService {
    Optional<Profile> getProfileByUserId(Long userId);

    Profile saveProfile(Profile profile);

    void deleteProfileByUserId(Long userId);
}
