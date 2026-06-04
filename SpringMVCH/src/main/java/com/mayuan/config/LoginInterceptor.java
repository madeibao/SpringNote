package com.mayuan.config;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginInterceptor
 * @Author：Mayuan
 * @Date 2022/3/27/0027 10:44
 * @Description TODO
 * @Version 1.0
 **/
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //放行:判断什么情况下登录

        //登录页面也会放行
        if (request.getRequestURI().contains("goLogin")) {
            return true;
        }


        //第一次登陆也应该放行
        if (request.getRequestURI().contains("login")) {
            return true;
        }


        if (session.getAttribute("userLoginInfo") != null) {
            return true;
        }

        //判断什么情况下没有登录
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
