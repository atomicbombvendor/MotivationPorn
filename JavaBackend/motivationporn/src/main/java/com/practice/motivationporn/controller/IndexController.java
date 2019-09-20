package com.practice.motivationporn.controller;

import cn.hutool.core.util.ObjectUtil;
import com.practice.motivationporn.entity.User;
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

        User user = (User) request.getSession().getAttribute("user");
        if (ObjectUtil.isNull(user)) {
            mv.setViewName("redirect:/user/login");
        } else {
            mv.setViewName("page/index");
            mv.addObject(user);
        }
        return mv;
    }

    @GetMapping(value = {"login"})
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("page/login");
        return mv;
    }
}
