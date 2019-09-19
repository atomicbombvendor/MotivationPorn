package com.practice.motivationporn.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Spring-security使用
 * @author haoyue
 */
public class SecurityUserDetail implements UserDetails, Serializable {

    private Long id;

    private String username;

    private String password;

    /**
     *  权限列表
     */
    private Set<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public SecurityUserDetail setUsername(String username) {
        this.username = username;
        return this;
    }

    public SecurityUserDetail setPassword(String password) {
        this.password = password;
        return this;
    }

    public SecurityUserDetail setAuthorities(Set<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
        return this;
    }

    public Long getId() {
        return id;
    }

    public SecurityUserDetail setId(Long id) {
        this.id = id;
        return this;
    }
}
