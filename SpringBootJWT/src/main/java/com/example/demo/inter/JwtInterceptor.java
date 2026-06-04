package com.example.demo.inter;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.demo.util.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JwtInterceptor
 * @Author：Mayuan
 * @Date 2023/9/8/0008 15:54
 * @Description TODO
 * @Version 1.0
 **/
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, Object> map = new HashMap<>();
        // 获取请求头中的Token，其实就是每次前端要给我们发送请求都要求给我们传递Token
        String token = request.getHeader("token");
        System.out.println("拦截器中的Token是:" + token);
        try {
            // 1.验证令牌
            JwtUtils.verifyToken(token);
            // 2.验证成功，请求放行
            return true;

        } catch (SignatureVerificationException e) {
            map.put("msg", "无效签名");
            e.printStackTrace();
        } catch (TokenExpiredException e) {
            map.put("msg", "token已过期");
            e.printStackTrace();
        } catch (AlgorithmMismatchException e) {
            map.put("msg", "算法不一致");
            e.printStackTrace();
        } catch (Exception e) {
            map.put("msg", "token无效");
            e.printStackTrace();
        }
        // 设置状态
        map.put("state", false);
        // 将map转为json
        String json = new ObjectMapper().writeValueAsString(map);
        // 相应json数据
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
