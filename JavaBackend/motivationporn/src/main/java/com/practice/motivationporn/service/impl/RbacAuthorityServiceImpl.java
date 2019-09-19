package com.practice.motivationporn.service.impl;

import com.practice.motivationporn.entity.SecurityUserDetail;
import com.practice.motivationporn.service.RbacAuthorityService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * @author haoyue
 */
@Service
@Component("rbacauthorityservice")
public class RbacAuthorityServiceImpl implements RbacAuthorityService {

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        Object userInfo = authentication.getPrincipal();
        boolean hasPermission;
        AntPathMatcher antPathMatcher = new AntPathMatcher();

        // 先校验是不是需要验认证的URL
        Set<String> unLoginPermission = unAuthenticatedPermission();
        hasPermission = matchUrl(antPathMatcher, request, unLoginPermission);

        if (hasPermission){
            return true;
        }

        if (userInfo instanceof SecurityUserDetail) {
            String userName = ((SecurityUserDetail) userInfo).getUsername();
            Set<String> loginPermission = authenticatedPermission();
            hasPermission = matchUrl(antPathMatcher, request, loginPermission);
        }

        return hasPermission;
    }

    private Set<String> authenticatedPermission(){

        Set<String> urls = new HashSet<>();
        // 这些 url 都是要登录后才能访问，且其他的 url 都不能访问！
        urls.add("/users/**");
        return urls;
    }

    private Set<String> unAuthenticatedPermission(){

        Set<String> urls = new HashSet<>();
        // 这些 url 都是要登录后才能访问，且其他的 url 都不能访问！
        urls.add("/");
        urls.add("/admin/info");
        urls.add("/user/info");
        return urls;
    }

    private boolean matchUrl(AntPathMatcher antPathMatcher, HttpServletRequest request, Set<String> urls){

        boolean hasPermission = false;
        for (String url : urls) {
            if (antPathMatcher.match(url, request.getRequestURI())) {
               hasPermission = true;
               break;
            }
        }
        return hasPermission;
    }
}
