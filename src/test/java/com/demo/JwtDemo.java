package com.demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtDemo {

    @Test
    public void testGenerateJwt() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 1);
        dataMap.put("username", "admin");

        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "aXRoZWltYQo=")
                .addClaims(dataMap)//添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))//设置过期时间
                .compact();
        System.out.println(jwt);
    }
    @Test
    public void testParseJwt() {
        String jwt ="eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc4MTE1OTI0OX0.c0AbbkJWqW6vIZdRr-NBd-xVyRsJm7PUIh4D7gqdsM0";
        Claims body = Jwts.parser().setSigningKey("aXRoZWltYQo=").parseClaimsJws(jwt).getBody();
        System.out.println(body);
    }
}
