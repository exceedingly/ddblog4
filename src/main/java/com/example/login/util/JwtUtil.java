package com.example.login.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.login.pojo.User;

public class JwtUtil {
    public static String getToken(User user) {
        String token = "";
        token = JWT.create().withAudience(user.getId() + "")
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }


    public static Integer getUserId(String token) {
        Integer userId = null;
        try {
            String idString = JWT.decode(token).getAudience().get(0);
            userId = Integer.parseInt(idString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userId;
    }


    public static boolean checkToken(String token, User user) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
