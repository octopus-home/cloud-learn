package com.octopus.service.impl;

import com.octopus.entity.User;
import com.octopus.repository.UserRepository;
import com.octopus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(String userId) {
        return userRepository.findUserById(Integer.valueOf(userId));
    }
}
