package com.www.testA;

import java.util.HashMap;

/**
 * @ClassName Map2
 * @Author：Mayuan
 * @Date 2023/8/8/0008 11:29
 * @Description TODO
 * @Version 1.0
 **/
public class Map2 {

    public static void main(String[] args) {

        HashMap<Integer,Integer> map2= new HashMap<>();

        for(int i=0;i<10;i++) {
            map2.put(i,i+1);
        }

        for(var i:map2.keySet()) {
            System.out.println(i+" "+map2.get(i));
        }
    }
}
