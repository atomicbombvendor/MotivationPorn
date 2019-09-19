package com.practice.motivationporn.Handler;

import com.alibaba.fastjson.JSON;
import com.practice.motivationporn.common.ResponseStatusEnum;
import com.practice.motivationporn.entity.AjaxResponseBody;
import com.practice.motivationporn.entity.SecurityUserDetail;
import com.practice.motivationporn.util.JwtTokenUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author haoyue
 */
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        AjaxResponseBody responseBody = new AjaxResponseBody();

        responseBody.setMsgAndCode(ResponseStatusEnum.SUCCESS);

        SecurityUserDetail userDetails = (SecurityUserDetail) authentication.getPrincipal();

        String jwtToken = JwtTokenUtil.generateToken(userDetails.getUsername(), null);
        responseBody.setToken(jwtToken);

        response.getWriter().write(JSON.toJSONString(responseBody));
    }
}
