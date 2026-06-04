package com.candy.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName CorsOriginConfig
 * @Author：Mayuan
 * @Date 2023/9/7/0007 15:28
 * @Description TODO
 * @Version 1.0
 **/
@Configuration
public class CorsOriginConfig{
    @Bean
    public WebMvcConfigurer corsConfigure(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
//                        .allowedOrigins("*")
                        .allowedOriginPatterns("*")
                        .allowedMethods("GET", "POST", "DELETE", "PUT")
                        .allowedHeaders("*")
                        .allowCredentials(true)
                        .exposedHeaders(HttpHeaders.SET_COOKIE)
                        .maxAge(3600 * 24);
            }
        };
    }
}