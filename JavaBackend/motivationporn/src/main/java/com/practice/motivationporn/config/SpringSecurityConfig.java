package com.practice.motivationporn.config;

import com.practice.motivationporn.Filter.JwtAuthenticationTokenFilter;
import com.practice.motivationporn.Handler.*;
import com.practice.motivationporn.service.SelfUserDetailsServiceImpl;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author haoyue
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private AjaxAuthenticationEntryPoint entryPoint;

    @Autowired
    private AjaxAuthenticationSuccessHandler successHandler;

    @Autowired
    private AjaxAuthenticationFailureHandler failureHandler;

    @Autowired
    private AjaxLogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private AjaxAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private SelfUserDetailsServiceImpl selfUserDetailsService;

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

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

                .and()
                .authorizeRequests()

                .anyRequest()
                // RBAC 动态 url 认证
                .access("@rbacauthorityservice.hasPermission(request, authentication)")

                .and()
                //开启登录
                .formLogin()
                // 登录成功时处理
                .successHandler(successHandler)
                // 登录失败时处理
                .failureHandler(failureHandler)
                .permitAll()

                .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .permitAll();

        // 记住我
        http.rememberMe().rememberMeParameter("remember-me")
                .userDetailsService(selfUserDetailsService).tokenValiditySeconds(300);

        // 无权访问 JSON 格式的数据
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
        // JWT Filter
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
