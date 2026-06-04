package com.mayuan.spring;

/**
 * @ClassName StaticFactory
 * @Author：Mayuan
 * @Date 2022/1/22/0022 22:46
 * @Description TODO
 * @Version 1.0
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂
 */
public class StaticFactory {
    private static Map<String, News> newsMap = new HashMap<String, News>();

    static {
        newsMap.put("news1", new News("StaticFactory标题1", "内容1"));
        newsMap.put("news2", new News("StaticFactory标题2", "内容2"));
    }

    public static News getNews(String name) {
        return newsMap.get(name);
    }

}