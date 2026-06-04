package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName EchartsController
 * @Author：Mayuan
 * @Date 2023/8/15/0015 10:46
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@RequestMapping("echarts")
public class EchartsController {

    @RequestMapping("demo1")
    public String demo1(){
        return "/echarts/demo1";
    }


    @GetMapping("demo2")
    public String demo2(){
        return "/echarts/demo2";
    }


    @PostMapping("demo2")
    @ResponseBody
    public Integer[] demo2data(){
        Integer[] i = new Integer[]{888,777,888,888,777,888,888};
        return i;
    }


    @GetMapping("demo3")
    public String demo3(){
        return "/echarts/demo3";
    }

    @GetMapping("demo4")
    public String demo4(){
        return "/echarts/demo4";
    }


    @PostMapping("demo3")
    @ResponseBody
    public Map demo3data(){
        Map map = new HashMap();
        Integer[] i = new Integer[]{888,777,888,888,777,888,888};
        map.put("num",i);
        String[] s = new String[]{"张三","777","888","888","777","888","李四"};
        map.put("str",s);
        return map;
    }


    @PostMapping("demo4")
    @ResponseBody
    public Map demo4data(){
        Map map = new HashMap();
        Integer[] i = new Integer[]{888,777,888,888,777,888,888};
        map.put("num",i);
        String[] s = new String[]{"张三","777","888","888","777","888","李四"};
        map.put("str",s);
        return map;
    }



    @PostMapping("demo5")
    @ResponseBody
    @CrossOrigin
    public Map demo5data(){
        Map map = new HashMap();
        Integer[] i = new Integer[]{888,777,888,888,777,888,888};
        map.put("num",i);
        String[] s = new String[]{"张三","777","888","888","777","888","李四"};
        map.put("str",s);
        return map;
    }


}
