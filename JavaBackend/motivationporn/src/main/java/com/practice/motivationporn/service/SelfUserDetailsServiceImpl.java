package com.practice.motivationporn.service;

import com.practice.motivationporn.entity.SecurityUserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        SecurityUserDetail userInfo = new SecurityUserDetail();
        userInfo.setUsername(userName);
        userInfo.setPassword(new BCryptPasswordEncoder().encode("123"));

        Set authoritiesSet = new HashSet();

        List<GrantedAuthority> ats = AuthorityUtils.commaSeparatedStringToAuthorityList("READ,ROLE_USER,ROLE_ADMIN");
        authoritiesSet.addAll(ats);
        userInfo.setAuthorities(authoritiesSet);

        return userInfo;
    }
}
