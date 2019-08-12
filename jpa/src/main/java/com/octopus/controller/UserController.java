package com.octopus.controller;

import com.octopus.entity.UserInfo;
import com.octopus.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class UserController {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping("addUser")
    public UserInfo addUser(String name, Integer age) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setAge(age);
        userInfo.setCreateDate(LocalDateTime.now());
        UserInfo save = userInfoRepository.save(userInfo);
        return save;
    }

    @GetMapping("getUserInfoById")
    public UserInfo getUserInfoById(Integer id) {
        UserInfo userInfoById = userInfoRepository.findUserInfoById(id);
        return userInfoById;
    }
}
