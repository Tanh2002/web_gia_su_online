package com.project.webgiasu.service;

import com.project.webgiasu.entity.User;

public interface IUserService {
    User addUser(User user);
    User getUserById(Long userId);
    User updateUser(Long userId, User user);

    void deleteUser(Long userId);

    User findByUsername(String username);
}
