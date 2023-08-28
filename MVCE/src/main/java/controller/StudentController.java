package controller;

import domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.StudentService;

import java.util.List;
import javax.annotation.Resource;

/**
 * @ClassName StudentController
 * @Author：Mayuan
 * @Date 2023/8/12/0012 16:42
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public ModelAndView regist(Student student) {
        String tip = "注册失败！";
        int i = studentService.addStudent(student);
        if (i > 0) {
            tip = "注册成功！";
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("tip", tip);
        mv.setViewName("afterRegist");

        return mv;
    }

    @RequestMapping(value = "/queryStudents",method = RequestMethod.GET)
    @ResponseBody
    public List<Student> queryStudents(String name, Integer age){
        //处理请求，参数检查，简单地处理

        List<Student> students = studentService.queryStudents();
        return students;
    }
}
