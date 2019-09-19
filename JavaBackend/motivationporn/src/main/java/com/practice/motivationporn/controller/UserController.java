package com.practice.motivationporn.controller;

import com.practice.motivationporn.util.ResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户模块，登录，注册等功能。
 * @author haoyue
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @PostMapping("/login")
    public void login(){

    }

    @GetMapping("/info")
    public Object getInfo(){

        Map<String, Object> info = new HashMap<>(1);
        info.put("info", "毒鸡汤网站的用户后台");
        return ResponseUtil.ok(info);
    }
}
