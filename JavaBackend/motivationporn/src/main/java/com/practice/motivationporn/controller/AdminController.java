package com.practice.motivationporn.controller;

import com.practice.motivationporn.service.PornService;
import com.practice.motivationporn.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haoyue
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PornService pornService;

    @GetMapping("/info")
    public Object getInfo(){

        Map<String, Object> info = new HashMap<>(1);
        info.put("info", "毒鸡汤网站的管理员后台");
        return ResponseUtil.ok(info);
    }

    @GetMapping("/allPorn")
    public Object getAllPorn(){

        return ResponseUtil.ok(pornService.getAll());
    }
}
