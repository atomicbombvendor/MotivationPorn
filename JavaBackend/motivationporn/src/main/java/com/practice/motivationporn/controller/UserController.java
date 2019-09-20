package com.practice.motivationporn.controller;

import com.practice.motivationporn.common.ResponseStatusEnum;
import com.practice.motivationporn.common.TokenEnum;
import com.practice.motivationporn.entity.User;
import com.practice.motivationporn.util.JwtTokenUtil;
import com.practice.motivationporn.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户模块，登录，注册等功能。
 * @author haoyue
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 从数据库中读取用户的权限信息
     * @param user
     * @param request
     * @return
     */
    @PostMapping("/login")
    public Object login(User user, HttpServletRequest request) {

        user.setRole("ROLE_USER");
        String token = JwtTokenUtil.generateToken(user.getUserName(), null);
        return ResponseUtil.ok(token);
    }

    /**
     * 登录出
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public Object logout(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (null != authHeader && authHeader.startsWith(TokenEnum.TITLE.getValue())) {
            String subject = JwtTokenUtil.parseSubject(authHeader);
            return ResponseUtil.ok(subject);
        }

        return ResponseUtil.fail(ResponseStatusEnum.TOKEN_INVALID);
    }


    /**
     * 刷新token
     * @param token
     * @return
     */
    @GetMapping("/refreshToken")
    public Object refreshToken(@RequestParam(value = "token") String token){

        String userName = JwtTokenUtil.parseSubject(token);
        String newToken = JwtTokenUtil.generateToken(userName, null);

        return ResponseUtil.ok(newToken);
    }

    @GetMapping("/info")
    public Object getInfo(){

        Map<String, Object> info = new HashMap<>(1);
        info.put("info", "毒鸡汤网站的用户后台");
        return ResponseUtil.ok(info);
    }
}
