package org.guava.example;

/**
 * @ClassName FunctionalProgrammingExample
 * @Author：Mayuan
 * @Date 2024/7/13/星期六 11:54
 * @Description TODO
 * @Version 1.0
 **/
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

public class FunctionalProgrammingExample {
    public static void main(String[] args) {
        List<String> words = Lists.newArrayList("nih","Guava", "Java", "Programming", "Functions");

        // 使用Guava的函数式编程接口进行转换和过滤
        Collection<String> filteredWords = Collections2.filter(Collections2.transform(words, new Function<String, String>() {
                    @Override
                    public String apply(String input) {
                        // 转换为大写
                        return input.toUpperCase();
                    }
                }), input -> input.length() >= 4 // 过滤长度小于4的字符串
        );

        System.out.println(filteredWords);
    }
}
