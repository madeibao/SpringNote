package com.mayuan.controller;

/**
 * @ClassName HelloController
 * @Author：Mayuan
 * @Date 2022/3/20/0020 17:02
 * @Description TODO
 * @Version 1.0
 **/

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 注意：这里我们先导入Controller接口
 */


public class HelloController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //ModelAndView 模型和视图
        ModelAndView mv = new ModelAndView();

        //封装对象，放在ModelAndView中。Model
        mv.addObject("msg","Hello, Welcome to the SpringMVC World");
        //封装要跳转的视图，放在ModelAndView中
        //: /WEB-INF/jsp/hello.jsp
        mv.setViewName("hello");
        return mv;
    }
}
