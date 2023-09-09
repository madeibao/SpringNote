package com.example.demo.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;

/**
 * @ClassName SerializuUtil
 * @Author：Mayuan
 * @Date 2023/9/9/0009 15:25
 * @Description TODO
 * @Version 1.0
 **/
public class SerializuUtil {

    public static byte[] serialize(Object object){
        ObjectOutputStream oos= null;
        ByteArrayOutputStream baos= null;
        try {
            baos=new ByteArrayOutputStream();
            oos=new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes=baos.toByteArray();
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将byte 数组转为java对象 反序列化
     */

    public static Object  unserialize(byte[]bytes){
        if (bytes==null){
            return null;
        }
        ByteArrayInputStream bais=null;
        try {
            bais=new ByteArrayInputStream(bytes);
            ObjectInputStream ois=new ObjectInputStream(bais);
            return ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
