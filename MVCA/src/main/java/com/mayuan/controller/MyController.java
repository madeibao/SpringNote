package com.mayuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName MyController
 * @Author：Mayuan
 * @Date 2023/8/11/0011 18:06
 * @Description TODO
 * @Version 1.0
 **/


@Controller
@RequestMapping(value = "/user")
public class MyController {

    /**
     * @RequestMapping : 请求映射
     *             属性： method， 表示请求的方式。 它的值RequestMethod类枚举值。
     *                    例如表示get请求方式， RequestMethod.GET
     *                    post方式， RequestMethod.POST
     *
     *  你不用get方式，错误是：
     *  HTTP Status 405 - Request method 'GET' not supported
     *  //指定some.do使用get请求方式
     */
    /**
     * //这是一个数组，可以写多个
     * @return
     */
    @RequestMapping(value = "/some.do",method = RequestMethod.GET)
    public ModelAndView doSome() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("mv01","欢迎使用springMVC框架！");
        mv.addObject("mv02","执行的是doSome方法！");
        mv.setViewName("show");
        return mv;

    }


    //指定other.do是post请求方式
    @RequestMapping(value = "/other.do",method = RequestMethod.POST)
    public ModelAndView doOther(){
        //处理完请求之后响应数据给客户端
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("other01","欢迎您使用springmvc！");
        modelAndView.setViewName("show");
        return modelAndView;
    }


    //不指定请求方式，没有限制
    @RequestMapping(value = "/first.do")
    public ModelAndView doFirst(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();

        ModelAndView mv = new ModelAndView();
        mv.addObject("first01","这里是first.do请求,获取请求的参数===="+request.getParameter("name"));
        mv.addObject("first02","当前工程名："+servletContext.getContextPath());
        mv.setViewName("show");
        return mv;
    }
}
