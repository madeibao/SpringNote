package com.mayuan.controller;

import com.google.gson.Gson;
import com.mayuan.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyController
 * @Author：Mayuan
 * @Date 2023/8/12/0012 11:16
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/user")
public class MyController {

    /**
     * 处理器方法返回String，表示逻辑视图名称，需要配置视图解析器
     * @param name
     * @param age
     * @param request
     * @return
     */
    @RequestMapping(value = "/returnString-view.do", method = RequestMethod.POST)
    public String doSome(String name, Integer age, HttpServletRequest request) {

        System.out.println("myName:" + name + "\n" + "myAge:" + age);

        //可以手动添加数据到request域中
        request.setAttribute("myName",name);
        request.setAttribute("myAge",age);

        //当返回完整视图路径时，不能配置视图解析器
        //框架对视图进行forward转发操作
        return "show";
    }

    /**
     * 处理方法返回void，响应ajax请求
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/returnVoid-ajax.do", method = RequestMethod.POST)
    public void returnVoid(String name, Integer age, HttpServletResponse response) {

        Student student = new Student(name,age);

        Gson gson = new Gson();
        String json = gson.toJson(student);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 处理器方法返回一个Student，通过框架转为json，响应ajax请求
     * @ResponseBody:
     *    作用：把处理器方法返回对象转为json后，通过HttpServletResponse输出给浏览器。
     *    位置：方法的定义上面。 和其它注解没有顺序的关系。
     * 返回对象框架的处理流程：
     *  1. 框架会把返回Student类型，调用框架的中ArrayList<HttpMessageConverter>中每个类的canWrite()方法
     *     检查那个HttpMessageConverter接口的实现类能处理Student类型的数据--MappingJackson2HttpMessageConverter
     *
     *  2.框架会调用实现类的write（）， MappingJackson2HttpMessageConverter的write()方法
     *    把李四同学的student对象转为json， 调用Jackson的ObjectMapper实现转为json
     *    contentType: application/json;charset=utf-8
     *
     *  3.框架会调用@ResponseBody把2的结果数据输出到浏览器， ajax请求处理完成
     */

    @RequestMapping(value = "/returnStudentJson.do")
    @ResponseBody
    public Student returnStudentJson(String name,Integer age){
        //调用service，获取请求的结果数据，student对象表示结果数据
        Student student = new Student("鸡脖",28);
        // 会被框架转为json
        return student;
    }

    @RequestMapping(value = "/returnListJson.do")
    @ResponseBody
    public List<Student> returnListJson(){
        //调用service，获取请求的结果数据，student对象表示结果数据
        Student student1 = new Student("鸡腿",28);
        Student student2 = new Student("鸭掌",18);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        // 会被框架转为json
        return students;
    }


    /**
     * 处理器方法返回String， String表示数据的，不是视图
     * 没有@ResponseBody注解表示返回的是视图，表示逻辑视图名称，需要配置视图解析器
     * 有@ResponseBody注解表示返回的是字符串数据
     * 默认使用“text/plain;charset=ISO-8859-1”作为contentType,导致中文有乱码，
     * 解决方案：给RequestMapping增加一个属性 produces, 使用这个属性指定新的contentType.
     * produces = "text/plain;charset=utf-8"
     *
     *   返回对象框架的处理流程：
     *     1. 框架会把返回String类型，调用框架的中ArrayList<HttpMessageConverter>中每个类的canWrite()方法
     *        检查那个HttpMessageConverter接口的实现类能处理String类型的数据--StringHttpMessageConverter
     *     2.框架会调用实现类的write（）， StringHttpMessageConverter的write()方法
     *       把字符按照指定的编码处理 text/plain;charset=ISO-8859-1
     *     3.框架会调用@ResponseBody把2的结果数据输出到浏览器， ajax请求处理完成
     */

    @RequestMapping(value = "/returnStringData.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String returnStringData(){
        return "hello SpringMVC 哈哈哈！";
    }

}
