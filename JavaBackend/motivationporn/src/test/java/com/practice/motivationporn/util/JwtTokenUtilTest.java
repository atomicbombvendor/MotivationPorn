package com.practice.motivationporn.util;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class JwtTokenUtilTest {

    @Test
    public void generateToken() {

        Map<String, Object> map = new HashMap<>();
        map.put("k1", "key1");
        map.put("k2", "key2");
        map.put("k3", "key3");
        map.put("k4", "key4");
        String token = JwtTokenUtil.generateToken("userId", map);
        System.out.println(token);
    }

    @Test
    public void parseSubject() {

        String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VySWQiLCJrMSI6ImtleTEiLCJrMiI6ImtleTIiLCJrMyI6ImtleTMiLCJrNCI6ImtleTQiLCJleHAiOjE1Njg4Nzk1NDB9.NMyD9GR4YzbkWmt84vE1_UHvguYA3rFlzjq8_hIe1I-xCqRePKbjA5u0aHwE0txZBdKee4tGMGd8QC-_4ExgQw";
        Object o = JwtTokenUtil.parseSubject(token);
        System.out.println(JSON.toJSONString(o));

    }
}