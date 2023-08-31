package com.newtouch.demo.config;

import com.newtouch.demo.realm.AccountRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ShrioConfig
 * @Author：Mayuan
 * @Date 2023/8/31/0031 10:35
 * @Description TODO
 * @Version 1.0
 **/
@Configuration
public class ShrioConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //权限设置
        Map<String,String> map=new HashMap<>();
        map.put("/main","authc");
        map.put("/manage","perms[manage]");
        map.put("/administrator","roles[administrator]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        //设置登陆页面
        shiroFilterFactoryBean.setLoginUrl("login");
        //设置未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("unauth");
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("accountRealm") AccountRealm accountRealm){
        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(accountRealm);
        return manager;
    }

    @Bean
    public AccountRealm accountRealm(){
        return new AccountRealm();
    }
}
