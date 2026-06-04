package com.mayuan.forward_redirect;

import com.mayuan.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName Forward_Redirect
 * @Author：Mayuan
 * @Date 2023/8/12/0012 14:56
 * @Description TODO
 * @Version 1.0
 **/
@Controller
public class Forward_Redirect {

    /**
     * 处理器方法返回ModelAndView,实现转发forward
     * forward可以转发到WEB-INF目录下的视图页面
     * 语法： setViewName("forward:视图文件完整路径")
     * forward特点： 不和视图解析器一同使用，就当项目中没有视图解析器
     */
    @RequestMapping(value = "/forward.do",method = RequestMethod.GET)
    public ModelAndView doForward(Student student){
        //参数中的对象会自动保存在request域中

        ModelAndView mv = new ModelAndView();

        mv.addObject("myName",student.getName());
        mv.addObject("myAge",student.getAge());

        //mv.setViewName("show2");//转发，使用视图解析器配置的路径前后缀

        //显示转发
        //1.可以转发到WEB-INF目录之下
        //mv.setViewName("forward:/WEB-INF/view/show2.jsp");
        //2.也可以转发到其他目录之下
        mv.setViewName("forward:/hello.jsp");
        return mv;
    }

    /**
     * 处理器方法返回ModelAndView,实现重定向redirect
     * 语法：setViewName("redirect:视图完整路径")
     * redirect特点： 不和视图解析器一同使用，就当项目中没有视图解析器
     *
     * 框架对重定向的操作：
     * 1.框架会把Model中的简单类型的数据，转为string使用，作为hello.jsp的get请求参数使用。
     *   目的是在 doRedirect.do 和 hello.jsp 两次请求之间传递数据
     *
     * 2.在目标hello.jsp页面可以使用参数集合对象 ${param}获取请求参数值
     *    ${param.myname}
     *
     * 3.重定向不能访问/WEB-INF资源
     */
    @RequestMapping(value = "/redirect.do",method = RequestMethod.POST)
    public ModelAndView doRedirect(Student student){
        ModelAndView mv = new ModelAndView();

        //可以把数据保存在request域中和param请求的参数中
        //在重定向中，是两次请求，request域中获取不到，所以可以使用param获取数据
        mv.addObject("myName",student.getName());
        mv.addObject("myAge",student.getAge());

        mv.setViewName("redirect:/hello.jsp");
        //http://localhost:8080/05-url_pattern/hello.jsp?myName=lisi&myAge=22
        return mv;
    }

    /**
     * 处理器方法返回String实现forward
     */
    @RequestMapping(value = "/forwardString",method = RequestMethod.POST)
    public String doForwardString(Student student, HttpServletRequest request){

        return "forward:/WEB-INF/view/show2.jsp";
    }
}
