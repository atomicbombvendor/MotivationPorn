package com.practice.motivationporn.service;

import com.practice.motivationporn.entity.SecurityUserDetail;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author haoyue
 */
@Service
@Component("userDetailsServiceImpl")
public class SelfUserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(SelfUserDetailsServiceImpl.class);

    @Autowired
    private MoUserService moUserService;

    /**
     * 主要工作是在初次登录时，读取用户名和密码。加密后，和前台传入的做校验。
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserDetails userDetails = moUserService.selectByName(userName);
        if (userDetails == null){
            throw new RuntimeException("User " + userName + " not exists");
        }

        return userDetails;
    }
}
