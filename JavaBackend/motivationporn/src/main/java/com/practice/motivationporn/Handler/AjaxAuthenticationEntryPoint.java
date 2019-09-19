package com.practice.motivationporn.Handler;

import com.alibaba.fastjson.JSON;
import com.practice.motivationporn.common.ResponseStatusEnum;
import com.practice.motivationporn.entity.AjaxResponseBody;
import org.checkerframework.checker.units.qual.A;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author haoyue
 */
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        AjaxResponseBody responseBody = new AjaxResponseBody();
        responseBody.setMsgAndCode(ResponseStatusEnum.NEED_AUTHORITIES_300);

        response.getWriter().write(JSON.toJSONString(responseBody));
    }
}
