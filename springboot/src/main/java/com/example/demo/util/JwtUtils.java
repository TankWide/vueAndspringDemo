package com.example.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.dao.entity.UserEntity;

public class JwtUtils {
    /**
     * @param user
     * @return String
     * @Title getToken
     * @Description 通过用户id与用户密码 生成token
     */
    public static String getToken(UserEntity user) {
        String token = "";
        token = JWT.create().withAudience(user.getId() + "")
                .sign(Algorithm.HMAC256(user.getId() + ""));
        return token;
    }

    /**
     * @param token
     * @return Integer
     * @Title getUserId
     * @Description 根据token获取userId
     */
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

    /**
     * @param token
     * @param user
     * @return boolean
     * @Title checkToken
     * @Description 验证token是否正常
     */
    public static boolean checkToken(String token, Integer userId) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(userId + "")).build();
        try {
            jwtVerifier.verify(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
