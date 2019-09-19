package com.practice.motivationporn.Handler;

import com.alibaba.fastjson.JSON;
import com.practice.motivationporn.common.ResponseStatusEnum;
import com.practice.motivationporn.entity.AjaxResponseBody;
import org.checkerframework.checker.units.qual.A;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author haoyue
 * 拒绝请求
 */
public class AjaxAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {

        AjaxResponseBody responseBody = new AjaxResponseBody();
        responseBody.setMsgAndCode(ResponseStatusEnum.NEED_AUTHORITIES_000);

        response.getWriter().write(JSON.toJSONString(responseBody));
    }
}
