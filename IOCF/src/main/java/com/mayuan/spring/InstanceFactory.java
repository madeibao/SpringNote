package com.mayuan.spring;

/**
 * @ClassName InstanceFactory
 * @Author：Mayuan
 * @Date 2022/1/22/0022 22:46
 * @Description TODO
 * @Version 1.0
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂
 */
public class InstanceFactory {
    Map<String,News> newsMap = new HashMap<String,News>();

    public InstanceFactory(){
        newsMap.put("news1",new News("InstanceFactory标题1","内容1"));
        newsMap.put("news2",new News("InstanceFactory标题2","内容2"));
    }

    public News getNews(String name){
        return newsMap.get(name);
    }
}