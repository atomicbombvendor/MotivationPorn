package com.practice.motivationporn.Handler;

import com.alibaba.fastjson.JSON;
import com.practice.motivationporn.common.ResponseStatusEnum;
import com.practice.motivationporn.entity.AjaxResponseBody;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author haoyue
 */
public class AjaxLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        AjaxResponseBody responseBody = new AjaxResponseBody();

        responseBody.setMsgAndCode(ResponseStatusEnum.LOGOUT);

        response.getWriter().write(JSON.toJSONString(responseBody));
    }
}
