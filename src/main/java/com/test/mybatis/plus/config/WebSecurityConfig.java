package com.test.mybatis.plus.config;


import com.test.mybatis.plus.filter.LoginSuccessHandle;
import com.test.mybatis.plus.filter.LogoutHandel;
import com.test.mybatis.plus.filter.LogoutSuccessHandle;
import com.test.mybatis.plus.filter.MyFilterSecurityInterceptor;
import com.test.mybatis.plus.service.impl.CustomUserService;
import com.test.mybatis.plus.utils.MD5Util;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.annotation.Resource;

/**
 * Created by yangyibo on 17/1/18.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;


    @Bean
    UserDetailsService customUserService() { //注册UserDetailsService 的bean
        return new CustomUserService();
    }
/*
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }*/



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());//user Details Service验证

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .authorizeRequests()
       /*         .anyRequest().authenticated() //任何请求,登录后可以访问*/
                .antMatchers("/css/**").permitAll()
                .antMatchers("/logoutYemian").permitAll()
                .antMatchers("/view").permitAll()
                .antMatchers("/poi").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home").successHandler(new LoginSuccessHandle())
                .failureUrl("/login?error")
                .permitAll() //登录页面用户任意访问
                .and()
                .logout()
                .logoutSuccessHandler(new LogoutSuccessHandle())
                .addLogoutHandler(new LogoutHandel())
                .permitAll(); //注销行为任意访问

        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class)
                .csrf().disable();


    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
        //可以仿照上面一句忽略静态资源
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

