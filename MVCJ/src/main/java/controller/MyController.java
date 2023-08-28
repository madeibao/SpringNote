package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author HLF
 * @version V1.0
 * @package controller
 * @date 2021/11/6 17:20
 */
@Controller
@RequestMapping(value = "/user")
public class MyController {

    @RequestMapping(value = "/doSome", method = RequestMethod.POST)
    public ModelAndView doException(String name, Integer age){
        System.out.println("====Controller____deployment ____MyController  doSome function====");

        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", name);
        mv.addObject("myAge", age);
        mv.setViewName("show");
        return mv;
    }
}
