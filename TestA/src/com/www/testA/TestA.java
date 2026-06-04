package com.www.testA;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName TestA
 * @Author：Mayuan
 * @Date 2023/8/8/0008 14:51
 * @Description TODO
 * @Version 1.0
 **/
public class TestA {
    public static void main(String[] args) {

        Set<Integer> set2 = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1-integer;
            }
        });

        set2.add(3);
        set2.add(2);
        set2.add(1);

        Iterator<Integer> it = set2.iterator();
        while (it.hasNext()) {
            System.out.println(it.next()+" ");
        }
    }
}
