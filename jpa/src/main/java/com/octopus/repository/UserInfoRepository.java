package com.octopus.repository;

import com.octopus.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
    UserInfo findUserInfoById(Integer id);
}
