package org.valid.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 验真controller拦截器内容
 *
 * @ClassName StudentController
 * @Author：Mayuan
 * @Date 2024/9/21/星期六 16:07
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping("Student")
public class StudentController {
//    /**
//     * 异常处理器
//     * @param e
//     * @return
//     */
//    @ResponseBody   // 通过异常处理器方法统一返回响应结果
//    @ExceptionHandler(Exception.class)
//    public String handleException1(Exception e) {
//        String msg = "Get Exception In handleException1 Method";
//        System.out.println("msg: " + msg);
//        return msg;
//    }

    /**
     * 运算异常处理器
     *
     * @param e
     * @return
     */
    @ResponseBody   // 通过异常处理器方法统一返回响应结果
    @ExceptionHandler(ArithmeticException.class)
    public String handleException2(ArithmeticException e) {
        String msg = "Get ArithmeticException In handleException2 Method";
        System.out.println("msg: " + msg);
        return msg;
    }

    @ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    public String handleException3(NumberFormatException e) {
        String msg = "Get NumberFormatException In handleException3 Method";
        System.out.println("msg: " + msg);
        return msg;
    }

    @ResponseBody
    @RequestMapping("/test1")
    public Integer test1(@RequestParam int a) {
        System.out.println(a);
        return a;
    }
}