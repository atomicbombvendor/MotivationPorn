package com.practice.motivationporn.entity;

import cn.hutool.core.util.EnumUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Spring-security使用
 * @author haoyue
 */
public class SecurityUserDetail implements UserDetails, Serializable {

    private static final long serialVersionUID = 7171722954972237961L;

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

    public static SecurityUserDetail getUserDetail(MotivationUser motivationUser){

        SecurityUserDetail userDetail = new SecurityUserDetail();
        userDetail.setUsername(motivationUser.getUserName());
        userDetail.setPassword(motivationUser.getPassword());
        String role = Priority.getValue(motivationUser.getPriority());

        Set authoritiesSet = new HashSet();
        List<GrantedAuthority> ats = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
        authoritiesSet.addAll(ats);
        userDetail.setAuthorities(authoritiesSet);

        return userDetail;
    }

    enum Priority{
        ADMIN(2, "ROLE_ADMIN"),
        USER(1, "ROLE_USER");

        private Integer index;

        private String value;

        Priority(Integer index, String value) {
            this.index = index;
            this.value = value;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public static String getValue(Integer index){

            if (index == null) {
                return null;
            }
            Priority p = EnumUtil.likeValueOf(Priority.class, index);
            if (p == null){
                return null;
            }
            return p.getValue();
        }
    }
}
