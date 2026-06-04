package com.lys.controller;
import com.lys.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/test")
public class MyController {
    /**
       逐个接收参数
       要求：控制器方法的形参名与请求中的参数必须一致
     */
    @RequestMapping(value = {"receive.do"},method = RequestMethod.POST)
    public ModelAndView doSome(String name, int age) {
            ModelAndView mv=new ModelAndView();
            //添加数据
            mv.addObject("myName",name);
            mv.addObject("myAge",age);
            //指定视图，指定视图的完整路径
            mv.setViewName("show");
            return mv;
    }
    /**
    如果形参中的名字与请求参数的名字不一样，则需要加入注解@RequestParam
    第一个属性value,他的值需要跟请求参数的名字一样
    第二个属性required,要求请求参数必须有值，否则报错，因为默认地是true
    位置：在处理器方法的形参前面
     */
    @RequestMapping(value = {"para.do"},method = RequestMethod.POST)
    public ModelAndView doParam(@RequestParam(value = "rname") String name, @RequestParam(value = "rage")int age){
        ModelAndView mv=new ModelAndView();
        //添加数据
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
        //指定视图，指定视图的完整路径m
        mv.setViewName("show");
        return mv;
    }

    @RequestMapping(value = {"object.do"},method = RequestMethod.POST)
    public ModelAndView doObject(Student student) {
        ModelAndView mv=new ModelAndView();
        //添加数据
        mv.addObject("studentName",student.getName());
        mv.addObject("studentAge",student.getAge());
        mv.addObject("student对象",student);
        //指定视图，指定视图的完整路径
        mv.setViewName("show");
        return mv;
    }

}
