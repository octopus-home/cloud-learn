package com.octopus.Util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.octopus.entity.User;

public class TokenUtil {
    private String getToken(User user) {
        String token = "";
        token = JWT.create().withAudience(user.getId().toString()).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
