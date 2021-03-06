package com.practice.motivationporn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 首页
 * @author haoyue
 */
@RestController
public class IndexController {

    /**
     * 跳转到登录页面，如果在浏览器中存储了token，则页面自己选择跳转还是其他。
     * @param request
     * @return
     */
    @GetMapping(value = {"", "/", "/login"})
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @GetMapping(value = {"/home"})
    public ModelAndView home(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("table/porn");
        return mv;
    }
}
