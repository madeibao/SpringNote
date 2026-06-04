package com.mayuan.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyInterceptor
 * @Author：Mayuan
 * @Date 2022/3/27/0027 10:44
 * @Description TODO
 * @Version 1.0
 **/
public class MyInterceptor implements HandlerInterceptor {
    //return true; 执行下一个拦截器，放行
    //return false; 不执行下一个拦截器，拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("===========处理前===========");
        return true;
    }

    /**
     * 日志
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("===========处理后===========");

    }
    /**
     * 日志
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("===========清理===========");

    }
}

