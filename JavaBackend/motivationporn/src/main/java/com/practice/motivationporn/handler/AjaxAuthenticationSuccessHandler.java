package com.practice.motivationporn.handler;

import com.alibaba.fastjson.JSON;
import com.practice.motivationporn.common.ResponseStatusEnum;
import com.practice.motivationporn.entity.SecurityUserDetail;
import com.practice.motivationporn.util.JwtTokenUtil;
import com.practice.motivationporn.util.ResponseUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author haoyue
 */
@Component
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        SecurityUserDetail userDetails = (SecurityUserDetail) authentication.getPrincipal();
        String jwtToken = JwtTokenUtil.generateToken(userDetails.getUsername(), null);
        Map<String, Object> map = new HashMap<>(1);
        map.put("token", jwtToken);
        Object object = ResponseUtil.result(ResponseStatusEnum.SUCCESS, map);
        response.getWriter().write(JSON.toJSONString(object));
    }
}
