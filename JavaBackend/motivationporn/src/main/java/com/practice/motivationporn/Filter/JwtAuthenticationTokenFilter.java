package com.practice.motivationporn.Filter;

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
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author haoyue
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private SelfUserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (null == authHeader || !authHeader.startsWith(TokenEnum.TITLE.getValue())){
            //token格式不正确
            filterChain.doFilter(request,response);
            return;
        }

        String subject = JwtTokenUtil.parseSubject(authHeader);

        // 解析token失败
        if (subject == null || subject.isEmpty()){

            AjaxResponseBody responseBody = new AjaxResponseBody();
            responseBody.setMsgAndCode(ResponseStatusEnum.TOKEN_INVALID);
            response.getWriter().write(JSON.toJSONString(responseBody));
            return;
        }

        if (SecurityContextHolder.getContext().getAuthentication() == null){

            // 获取用户的权限信息
            UserDetails userDetails = userDetailsService.loadUserByUsername(subject);

            if (userDetails != null){
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // 将信息交给 security
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
