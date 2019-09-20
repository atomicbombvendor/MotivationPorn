package com.practice.motivationporn.config;

import com.practice.motivationporn.filter.JwtAuthenticationTokenFilter;
import com.practice.motivationporn.handler.*;
import com.practice.motivationporn.service.SelfUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;


/**
 * @author haoyue
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {

    SecurityContextPersistenceFilter xx;
    private final AjaxAuthenticationEntryPoint entryPoint;

    private final AjaxAuthenticationSuccessHandler successHandler;

    private final AjaxAuthenticationFailureHandler failureHandler;

    private final AjaxLogoutSuccessHandler logoutSuccessHandler;

    private final AjaxAccessDeniedHandler accessDeniedHandler;

    private final SelfUserDetailsServiceImpl selfUserDetailsService;

    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    public SpringSecurityConfig(@Autowired AjaxAuthenticationEntryPoint entryPoint,
                                @Autowired AjaxAuthenticationSuccessHandler successHandler,
                                @Autowired AjaxAuthenticationFailureHandler failureHandler,
                                @Autowired AjaxLogoutSuccessHandler logoutSuccessHandler,
                                @Autowired AjaxAccessDeniedHandler accessDeniedHandler,
                                @Autowired SelfUserDetailsServiceImpl userDetailsServiceImpl,
                                @Autowired JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter) {

        this.entryPoint = entryPoint;
        this.successHandler = successHandler;
        this.failureHandler = failureHandler;
        this.logoutSuccessHandler = logoutSuccessHandler;
        this.accessDeniedHandler = accessDeniedHandler;
        this.selfUserDetailsService = userDetailsServiceImpl;
        this.jwtAuthenticationTokenFilter = jwtAuthenticationTokenFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(selfUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 去掉 CSRF
        http.csrf().disable()
                //关闭session管理，使用token机制处理
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                .httpBasic().authenticationEntryPoint(entryPoint)

                .and().authorizeRequests()

                //放行login(这里使用自定义登录)
                .and().authorizeRequests().antMatchers("/").permitAll()
                .and().authorizeRequests().antMatchers("/user/login").permitAll()
                .and().authorizeRequests().antMatchers("/user/logout").permitAll()
                .and().authorizeRequests().antMatchers("/porn/random").permitAll()
                .and().authorizeRequests().antMatchers("/user/info").permitAll()
                .and().authorizeRequests().antMatchers("/admin/info").hasRole("ADMIN")
                .antMatchers(
                        HttpMethod.GET,
                        "/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js"
                ).permitAll()
                // 剩下的URL，开启认证
                .anyRequest()
                // RBAC 动态 url 认证
                .access("@rbacauthorityservice.hasPermission(request, authentication)");

        // 记住我
        http.rememberMe().rememberMeParameter("remember-me")
                .userDetailsService(selfUserDetailsService).tokenValiditySeconds(300);

        // 无权访问 JSON 格式的数据
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);

        // JWT Filter
        // 在所有请求的URL之前做了过滤
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
