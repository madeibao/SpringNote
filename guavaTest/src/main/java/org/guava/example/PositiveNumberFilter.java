package org.guava.example;

/**
 * @ClassName PositiveNumberFilter
 * @Author：Mayuan
 * @Date 2024/7/13/星期六 16:32
 * @Description TODO
 * @Version 1.0
 **/
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;

public class PositiveNumberFilter {
    public static void main(String[] args) {
        List<Integer> numbers = Lists.newArrayList(1, -2, 3, -4, 5);

        // 使用Guava的Predicates过滤
        Collection<Integer> positiveNumbers = Collections2.filter(numbers,
                new Predicate<Integer>() {
                    @Override
                    public boolean apply(Integer number) {
                        return number > 0;
                    }
                });

        System.out.println(positiveNumbers);
    }
}
