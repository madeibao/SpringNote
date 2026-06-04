package com.example.demo.shrio;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName ShiroConfig
 * @Author：Mayuan
 * @Date 2023/9/16/0016 20:03
 * @Description TODO
 * @Version 1.0
 **/
@Configuration
public class ShiroConfig {
    /**
     * 创建shiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 添加shiro的内置过滤器shiroFilter---实现对各种url的拦截
        // 常用的过滤器:
        /**
         * anon:无需登录认证即可访问
         * authc:必须认证才可以访问
         * user:使用rememberMe的功能可以访问
         * perms:该资源必须得到资源权限才可以访问--资源
         * role:该资源必须得到角色权限才可以访问--角色
         */
        Map<String,String> filterMap = new LinkedHashMap<String,String>();

        /**
         filterMap.put("/add","authc");
         filterMap.put("/update","authc");
            // 放行
         **/
        filterMap.put("/testThymeleaf","anon");
        filterMap.put("/login.action","anon");

        // 授权过滤器
        // 注意：当前授权拦截后，shiro会自动跳转到未授权的页面
        // 拦截所有add请求
        filterMap.put("/add","perms[user:add:*]");
        filterMap.put("/update","perms[user:update:*]");
        // 拦截
        filterMap.put("/*","authc");
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 设置未授权的提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }
    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    /**
     * 创建Reaml对象
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }

    /**
     * 配置shiro的dialet,用于thymeleaf和shiro的配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
