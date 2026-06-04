package com.example.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;


/**
 * @ClassName ServletContainersInitConfig
 * @Author：Mayuan
 * @Date 2023/9/14/0014 11:01
 * @Description TODO
 * @Version 1.0
 **/
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {

    /** 加载springMVC容器配置*/
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringMvcConfig.class);
        return ctx;
    }

    /**设置哪些请求归属Springmvc处理*/
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /** 加载spring容器配置*/
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }

    /**编码处理*/
    @Override
    protected Filter[] getServletFilters(){
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[]{filter};
    }
}
