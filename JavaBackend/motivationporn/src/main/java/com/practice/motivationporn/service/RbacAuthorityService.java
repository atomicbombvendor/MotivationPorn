package com.practice.motivationporn.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author haoyue
 */
public interface RbacAuthorityService {

    /**
     * 校验是否有权限
     * @param request
     * @param authentication
     * @return
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
