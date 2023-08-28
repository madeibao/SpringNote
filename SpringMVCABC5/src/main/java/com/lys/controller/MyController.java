package com.lys.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ASUS
 */
@Controller
public class MyController {
    /**
       逐个接收参数
       要求：控制器方法的形参名与请求中的参数必须一致
     */
    @RequestMapping(value = {"doSome.do"},method = RequestMethod.POST)
    public ModelAndView doSome(HttpServletRequest request,String name, int age){

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("myName",name);
        modelAndView.addObject("myAge",age);
        modelAndView.setViewName("show");
        return modelAndView;

    }

}
