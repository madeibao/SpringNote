package com.example.demo.config;

import com.example.demo.inter.JwtInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName JwtConfig
 * @Author：Mayuan
 * @Date 2023/9/8/0008 15:53
 * @Description TODO
 * @Version 1.0
 **/
public class JwtConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                // 添加拦截器
                .addInterceptor(new JwtInterceptor())
                // 默认拦截所有的请求
                .addPathPatterns("/**")
                // 放行登录请求(不能把登录也拦截，因为如果拦截了就意味着登录不了了)
                .excludePathPatterns("/user/login");
    }
}
