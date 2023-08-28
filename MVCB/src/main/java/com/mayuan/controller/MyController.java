package com.mayuan.controller;

import com.mayuan.vo.School;
import com.mayuan.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName MyController
 * @Author：Mayuan
 * @Date 2023/8/12/0012 10:42
 * @Description TODO
 * @Version 1.0
 **/


@Controller
@RequestMapping(value = "/user")
public class MyController {

    /**
     *
     * @param name
     * @param age
     * @param request
     * @return
     * value是一个数组，可以是一个，可以是多个
     */
    @RequestMapping(value = {"/login.do", "/login2.do"}, method = RequestMethod.POST)
    public ModelAndView doSome(String name, Integer age, HttpServletRequest request) {

        System.out.println("myName:" + name + "\n" + "myAge:" + age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", name);
        mv.addObject("myAge", age);
        mv.setViewName("show");
        return mv;
    }

    /**
     * 请求中参数名和处理器方法的形参名不一样
     *
     * @RequestParam: 逐个接收请求参数中， 解决请求中参数名形参名不一样的问题
     * 属性：
     * 1. value 请求中的参数名称
     * 2. required 是一个boolean，默认是true
     * true：表示请求中必须包含此参数。如果没有该参数会报400错误
     * false：没有此参数也会完成跳转
     * 位置： 在处理器方法的形参定义的前面
     */
    @RequestMapping(value = "/login3.do", method = RequestMethod.GET)
    public ModelAndView second(
            @RequestParam(value = "rname", required = false) String name,
            @RequestParam(value = "rage", required = false) String age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName2", name);
        mv.addObject("myAge2", age);
        mv.setViewName("show");
        return mv;
    }

    /**
     * 处理器方法形参是java对象(可以有多个java对象)， 这个对象的属性名和请求中参数名一样的
     * 框架会创建形参的java对象， 给属性赋值。 请求中的参数是name，框架会调用setName()
     * 形参中的java对象会自动保存在request域中
     */
    @RequestMapping(value = "/login4.do", method = RequestMethod.GET)
    public ModelAndView third(Student student) {
        String name = student.getName();
        Integer age = student.getAge();
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName3", name);
        mv.addObject("myAge3", age);
        mv.setViewName("show");
        return mv;
    }

    /**
     * 当形参有多个java对象
     */
    @RequestMapping(value = "/login5.do")
    public ModelAndView fourth(Student student, School school){
        String name = student.getName();
        Integer age = student.getAge();
        String sName = school.getsName();
        String sAddress = school.getsAddress();
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName4", name);
        mv.addObject("myAge4", age);
        mv.addObject("sName",sName);
        mv.addObject("sAddress",sAddress);
        mv.setViewName("show");
        return mv;
    }


}
