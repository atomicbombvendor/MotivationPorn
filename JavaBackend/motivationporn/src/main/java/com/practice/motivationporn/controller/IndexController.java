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
     * 这里应该分流，如果登录，如果没有登录。
     * @param request
     * @return
     */
    @GetMapping(value = {"", "/"})
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/admin/info");
        return mv;
    }

}
