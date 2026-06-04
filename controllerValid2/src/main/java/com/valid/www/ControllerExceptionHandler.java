package com.valid.www;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ControllerExceptionHandler
 * @Author：Mayuan
 * @Date 2024/9/21/星期六 17:10
 * @Description TODO
 * @Version 1.0
 **/
@ControllerAdvice
public class ControllerExceptionHandler {

//    /**
//     * 异常处理器
//     * @param e
//     * @return
//     */
//    @ResponseBody
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
    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    public String handleException2(ArithmeticException e) {
        String msg = "Get ArithmeticException In handleException2 Method";
        System.out.println("msg: " + msg);
        return msg;
    }

    @ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    public String handleException3(NumberFormatException e) {
        String msg = "test is Get NumberFormatException In handleException3 Method";
        System.out.println("msg: " + msg);
        return msg;
    }
}