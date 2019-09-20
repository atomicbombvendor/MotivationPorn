package com.practice.motivationporn.filter;

import com.alibaba.fastjson.JSON;
import com.practice.motivationporn.common.ResponseStatusEnum;
import com.practice.motivationporn.common.TokenEnum;
import com.practice.motivationporn.entity.AjaxResponseBody;
import com.practice.motivationporn.service.SelfUserDetailsServiceImpl;
import com.practice.motivationporn.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author haoyue
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final SelfUserDetailsServiceImpl userDetailsService;

    public JwtAuthenticationTokenFilter(@Autowired SelfUserDetailsServiceImpl userDetailsServiceImpl) {

        this.userDetailsService = userDetailsServiceImpl;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (null != authHeader && authHeader.startsWith(TokenEnum.TITLE.getValue())) {
            String subject = JwtTokenUtil.parseSubject(authHeader);

            //可以添加从token中读取信息的功能
            // 解析token失败
            if (subject == null || subject.isEmpty()) {

                AjaxResponseBody responseBody = new AjaxResponseBody();
                responseBody.setMsgAndCode(ResponseStatusEnum.TOKEN_INVALID);
                response.getWriter().write(JSON.toJSONString(responseBody));
                return;
            }

            // 有token，但是用户没有认证过。getContext中没有用户认证信息
            if (SecurityContextHolder.getContext().getAuthentication() == null) {

                // 获取用户的权限信息
                UserDetails userDetails = userDetailsService.loadUserByUsername(subject);

                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    // 将信息交给 security
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}