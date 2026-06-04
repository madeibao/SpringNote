package controller;

import exception.AgeException;
import exception.MyUserException;
import exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName MyController
 * @Author：Mayuan
 * @Date 2023/8/14/0014 15:14
 * @Description TODO
 * @Version 1.0
 **/
@Controller
public class MyController {

    @RequestMapping(value = "/doException.do", method = RequestMethod.POST)
    public ModelAndView doException(String name, Integer age) throws MyUserException {
        ModelAndView mv = new ModelAndView();

        //根据请求的参数抛出异常
        if (!"zs".equals(name)) {
            throw new NameException("姓名不正确！");
        }
        if(age == null || age> 80){
            throw new AgeException("年龄为空或者年龄过大！");
        }

        mv.addObject("myName", name);
        mv.addObject("myAge", age);
        mv.setViewName("show");
        return mv;
    }
}
