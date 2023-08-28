package com.lys.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lys.vo.Student;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
@Controller
public class MyController {
    /**
       逐个接收参数
       要求：控制器方法的形参名与请求中的参数必须一致
     */
    @RequestMapping(value = {"test/returnString-view.do"},method = RequestMethod.POST)
    public String doSome(HttpServletRequest request,String name, int age){
        request.setAttribute("myName",name);
        request.setAttribute("myAge",age);
        System.out.println("name"+name+" age"+age);
        return "show";
    }

    @RequestMapping(value = {"returnVoid-ajax.do"})
    public void doAjax(HttpServletResponse response,String name, int age) throws IOException {
        System.out.println("name"+name+" age"+age);
        //处理Ajax，需要使用json处理格式
        Student student=new Student();
        student.setAge(age);
        student.setName(name);
        //把结果转为JSON格式
        ObjectMapper objectMapper=new ObjectMapper();
        String json=objectMapper.writeValueAsString(student);
        //输出数据，相应ajax请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw=response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
        HttpMessageConverter httpMessageConverter=null;
    }


    @RequestMapping(value = {"returnObject-ajax.do"})
    @ResponseBody
    public Student objectAjax(String name, int age)
    {
        Student student=new Student();
        student.setName(name);
        student.setAge(age);
        return student;
    }


    @RequestMapping(value = {"returnObjectArr-ajax.do"})
    @ResponseBody
    public List<Student> objectsAjax(String name, Integer age) {
        List<Student> list=new ArrayList<>();
        Student student=new Student();
        student.setName("小红");
        student.setAge(20);
        list.add(student);
        Student student1=new Student();
        student1.setName("小七");
        student1.setAge(24);
        list.add(student1);
        return list;
    }

    @RequestMapping(value = {"returnString-ajax.do"}, produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String stringAjax(String name, Integer age) {
        String s = "返回String文本类型"+name+"   "+age;
        return s;
    }
}
