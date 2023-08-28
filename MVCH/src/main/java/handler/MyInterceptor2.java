package handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * @ClassName MyInterceptor2
 * @Author：Mayuan
 * @Date 2023/8/14/0014 16:50
 * @Description TODO
 * @Version 1.0
 **/
/**拦截器类：拦截用户的请求
 *
 *
 * @author ASUS*/

public class MyInterceptor2 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("2222====执行MyInterceptor中的preHandle方法====");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("2222====执行MyInterceptor中的postHandle方法====");

        //对原来doSome方法的执行结果进行二次修改
        if (modelAndView != null) {
            //修改数据
            modelAndView.addObject("date",
                    new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS").format(new Date()));
            //修改视图
            modelAndView.setViewName("other");
        }
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("2222====执行MyInterceptor中的afterCompletion方法====");
    }
}

/**
 * 两个拦截器的preHandle方法都返回true时的执行顺序：
 * 1111====执行MyInterceptor中的preHandle方法====
 * 2222====执行MyInterceptor中的preHandle方法====
 * ====执行MyController中的doSome方法====
 * 2222====执行MyInterceptor中的postHandle方法====
 * 1111====执行MyInterceptor中的postHandle方法====
 * 2222====执行MyInterceptor中的afterCompletion方法====
 * 1111====执行MyInterceptor中的afterCompletion方法====
 *
 * 1==2==doSome==2==1
 */

/**
 * 当拦截器1返回true，拦截器2返回false时执行顺序：
 * 1111====执行MyInterceptor中的preHandle方法====
 * 2222====执行MyInterceptor中的preHandle方法====
 * 1111====执行MyInterceptor中的afterCompletion方法====
 */

/**
 * 当拦截器1返回true，拦截器2返回true||false时执行顺序：
 * 1111====执行MyInterceptor中的preHandle方法====
 */



