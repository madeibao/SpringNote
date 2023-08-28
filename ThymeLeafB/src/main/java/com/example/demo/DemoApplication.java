package com.example.demo;

import com.example.demo.vo.UserVo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("/")
    public ModelAndView index(){
        ArrayList<UserVo> userVos = new ArrayList<>();
        UserVo userVo = new UserVo();
        userVo.setId(1);
        userVo.setUsername("huznzi");
        userVos.add(userVo);
        UserVo userVo2 = new UserVo();
        userVo2.setId(2);
        userVo2.setUsername("huznzi2");
        userVos.add(userVo2);

        ModelAndView mv=new ModelAndView();
        mv.addObject("newText","你好，springboot-thymeleaf");
        mv.addObject("gender","1");
        mv.addObject("userList",userVos);
        mv.addObject("loginUser",userVo);
        mv.setViewName("index.html");
        return mv;
    }

}
