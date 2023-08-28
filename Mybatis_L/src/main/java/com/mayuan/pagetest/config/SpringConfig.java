package com.mayuan.pagetest.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @ClassName SpringConfig
 * @Author：Mayuan
 * @Date 2023/8/18/0018 9:48
 * @Description TODO
 * @Version 1.0
 **/
//声明配置文件
@Configuration
//开启包扫描
@ComponentScan("com.mayuan.pagetest")
//开启AOP
@EnableAspectJAutoProxy
//开启映射扫描
@MapperScan("com.mayuan.pagetest.mapper")
public class SpringConfig {
    @Autowired
    private JdbcConfig jdbcConfig;
    //获取dataSource
    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(jdbcConfig.getDriver());
        dataSource.setUrl(jdbcConfig.getUrl());
        dataSource.setUsername(jdbcConfig.getUsername());
        dataSource.setPassword(jdbcConfig.getPasswrod());
        dataSource.setMaxActive(jdbcConfig.getMax());
        dataSource.setMinIdle(jdbcConfig.getMin());
        return dataSource;
    }

    //获取session
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Qualifier("dataSource") DruidDataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

}
