package com.example.demo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName SecurityConfig
 * @Author：Mayuan
 * @Date 2023/9/7/0007 9:23
 * @Description TODO
 * @Version 1.0
 **/
/** AOP:拦截器
 * @author ASUS*/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 链式编程
    // 授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 首页所有人可以访问,功能页只有对应有权限的人才能访问
        // 请求授权的规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        // 没有权限默认会到登录页,需要开启登录页面
        // 定制登录页
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password");

        // 防止网站攻击:get,post
        http.csrf().disable();//关闭csrf功能

        // 注销,开启了注销功能,清除cookie和session
        // http.logout().deleteCookies("remove").invalidateHttpSession(true);
        // 注销后跳到首页
        http.logout().logoutSuccessUrl("/");

        // 开启记住我功能,自定义接收前端的参数
        http.rememberMe().rememberMeParameter("remember");
    }

    // 认证, springboot2.1.x 可以直接使用
    // 密码编码:PasswordEncoder
    // 在Spring Security 5.0+ 新增了很多的加密方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 这些数据正常应该从数据库中读取
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("kuangshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}
