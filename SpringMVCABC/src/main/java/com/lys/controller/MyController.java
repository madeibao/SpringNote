package com.lys.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/test")
public class MyController {


    /**
        @RequestMapping:
        value:所有请求地址的公共部分，叫模块名称
        位置：放在类的上面
        method:表示请求方式
     */
    @RequestMapping(value = {"some.do"},method = RequestMethod.GET)
    public ModelAndView doSome(){
        ModelAndView mv=new ModelAndView();
        //添加数据
        mv.addObject("msg","使用SpringMVC开发,doSome");
        //指定视图，指定视图的完整路径
        mv.setViewName("show");
        return mv;
    }


    @RequestMapping(value =  {"other.do","second.do"}, method=RequestMethod.POST)
    public ModelAndView doOther() {
        ModelAndView mv=new ModelAndView();
        //添加数据
        mv.addObject("msg","使用SpringMVC开发,other");
        //指定视图，指定视图的完整路径
        mv.setViewName("other");
        return mv;
    }


    @RequestMapping(value = "first.do")
    public ModelAndView doFirst(){
        ModelAndView mv=new ModelAndView();
        //添加数据
        mv.addObject("msg","使用SpringMVC开发,dofirst");
        //指定视图，指定视图的完整路径
        mv.setViewName("First");
        return mv;
    }
}
