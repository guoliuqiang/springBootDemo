package com.lhosdp.jwt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {

    private String secret = "token!@#agent!@#belink";

    /*生成token*/
    public String getToken(Map<String,String> map){
        Calendar instance = Calendar.getInstance();
        //设置30分钟过期
        instance.add(Calendar.HOUR,2);

        //创建JWT builder
        JWTCreator.Builder builder = JWT.create();

        //payload
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        //sign
        builder.withExpiresAt(instance.getTime());
        String token = builder.sign(Algorithm.HMAC256(secret));
        return token;
    }
    /*验证token*/
    public DecodedJWT verify(String token) throws TokenExpiredException {
        //创建JWT验证对象 验证token
        return JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
    }


    public static void main(String[] args) {


        //使用方法验证token
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTm8iOiIxMjc5ODc3MTIiLCJ1c2VyTG9naW5OYW1lIjoiZ3VvbHEiLCJ1c2VyTmFtZSI6InlhbmdiaCIsImV4cCI6MTc2NTg2Nzk5N30.2c61bSL-8BIeIDT25YAODbCEOsew4ljF4Z--LqJmw2U";
//        System.out.println("使用方法验证token");
//        DecodedJWT verify = JWT.require(Algorithm.HMAC256("token!@#agent!@#belink")).build().verify(token);
//        System.out.println(verify.getClaim("userNo").asString());
//        System.out.println(verify.getClaim("userName").asString());
//        System.out.println(verify.getClaim("userLoginName").asString());
//        System.out.println(verify.getExpiresAt());
//
//        DecodedJWT verify1 = new JWTUtils().verify(token);
//        System.out.println(verify1.getClaim("userNo").asString());
//        System.out.println(verify1.getClaim("userName").asString());
//        System.out.println(verify1.getClaim("userLoginName").asString());
//        System.out.println(verify1.getExpiresAt());


        //生成  token  token!@#agent!@#belink
//        System.out.println("生成token");
//        String token = JWT.create()
//                .withClaim("userNo","127987712")
//                .withClaim("userLoginName","yangbh")
//                .withClaim("userName","郭龙辉")
//                .sign(Algorithm.HMAC256("token!@#agent!@#belink"));
//        System.out.println("Bearer " + token);
        //eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTm8iOiIxMjc5ODc3MTIiLCJ1c2VyTG9naW5OYW1lIjoiZ3VvbGgiLCJ1c2VyTmFtZSI6IumDrem-mei-iSJ9.ecnM4eYZvwik9xTloappdy2V4357QVZsm0eYjzuk-Xg
        //前缀 Bearer

        Map<String, String> userInfoMap = new HashMap<>();
        userInfoMap.put("userNo","127987712");
        userInfoMap.put("userName", "yangbh");
        userInfoMap.put("userLoginName", "guolq");
        String tokenresult = new JWTUtils().getToken(userInfoMap);
        System.out.println("Bearer " + tokenresult);

    }
}
