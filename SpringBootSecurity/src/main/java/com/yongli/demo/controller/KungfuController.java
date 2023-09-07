package com.yongli.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName KungfuController
 * @Author：Mayuan
 * @Date 2023/9/6/0006 20:38
 * @Description TODO
 * @Version 1.0
 **/
@Controller
public class KungfuController {
    private final String PREFIX = "pages/";
    /**
     * 欢迎页
     * @return
     */
    @GetMapping("/")
    public String index() {
        System.out.println("欢迎页");
        return "welcome";
    }

    /**
     * 登陆页
     * @return
     */
    @GetMapping("/userlogin")
    public String loginPage() {

        System.out.println("登录页");
        return PREFIX+"login";
    }


    /**
     * level1页面映射
     * @param path
     * @return
     */
    @GetMapping("/level1/{path}")
    public String level1(@PathVariable("path")String path) {
        return PREFIX+"level1/"+path;
    }

    /**
     * level2页面映射
     * @param path
     * @return
     */
    @GetMapping("/level2/{path}")
    public String level2(@PathVariable("path")String path) {
        return PREFIX+"level2/"+path;
    }

    /**
     * level3页面映射
     * @param path
     * @return
     */
    @GetMapping("/level3/{path}")
    public String level3(@PathVariable("path")String path) {
        return PREFIX+"level3/"+path;
    }


}
