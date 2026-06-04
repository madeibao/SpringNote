package com.lys.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author ASUS
 */
@Controller
public class MyController {
    /**
        使用@RequestMapping:把一个请求和一个方法绑定在一起
        它有一个属性，就是为了把请求的url与方法绑定在一起
        返回值：ModelAndView
        Model:数据，要显示给用户的数据
        View:视图，比如jsp页面
     */

    @RequestMapping(value = {"/some.do","/first.do"})
    public ModelAndView doSome() {
            ModelAndView mv=new ModelAndView();
            //添加数据
            mv.addObject("msg","使用SpringMVC开发");
            //指定视图，指定视图的完整路径
            mv.setViewName("show");
            return mv;
    }

    @RequestMapping(value = {"/other.do", "/second.do"})
    public ModelAndView doOther(){
        ModelAndView mv=new ModelAndView();
        //添加数据
        mv.addObject("msg","使用SpringMVC开发");
        //指定视图，指定视图的完整路径
        mv.setViewName("other");
        return mv;
    }
}
