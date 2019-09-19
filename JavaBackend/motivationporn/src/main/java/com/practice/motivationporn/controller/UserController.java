package com.practice.motivationporn.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
