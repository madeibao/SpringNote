package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName MyController
 * @Author：Mayuan
 * @Date 2023/8/14/0014 16:01
 * @Description TODO
 * @Version 1.0
 **/

@Controller
@RequestMapping(value = "/user")
public class MyController {

    @RequestMapping(value = "/doSome", method = RequestMethod.POST)
    public ModelAndView doException(String name, Integer age){
        System.out.println("====执行MyController中的doSome方法====");

        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", name);
        mv.addObject("myAge", age);
        mv.setViewName("show");
        return mv;
    }
}
