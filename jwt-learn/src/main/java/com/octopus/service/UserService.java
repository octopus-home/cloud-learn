package com.octopus.service;

import com.octopus.entity.User;

public interface UserService {
    User findUserById(String userId);
}
