package com.candy.test;

import com.candy.dao.UserInfoMapper;
import com.candy.pojo.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DBDriver
 * @Author：Mayuan
 * @Date 2023/8/30/0030 15:40
 * @Description TODO
 * @Version 1.0
 **/

/**
 *
 *
 * Mybatis的逆向工程，来生成所需要的mapper和 pojo 文件
 * 注意插件要安装
 * <artifactId>mybatis-generator-maven-plugin</artifactId>
 *
 *
 * 点击 右侧Maven
 * MybatisCache2
 *      Mybatis-generator
 *      双击mybatis-generator:generate
 * @author ASUS
 *
 *
 */


public class DBDriver {

    public static void test08() {
        try {

            String resource = "mybatis-config.xml";
//            读取配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
//            创建SqlSessionFactory实例
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//           SqlSession相当于JDBC中的statement，用来执行具体的增删改查的
            SqlSession session = sqlSessionFactory.openSession();
            UserInfoMapper mapper=   session.getMapper(UserInfoMapper.class);
            UserInfo userinfo=new UserInfo();
            userinfo.setUsername("张");

            List<UserInfo> userinfoes= mapper.selectUserByParams3(userinfo,"青");
            for (UserInfo user:userinfoes) {
                System.out.println(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test07() {
        try {
            String resource = "mybatis-config.xml";
//            读取配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
//            创建SqlSessionFactory实例
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//           SqlSession相当于JDBC中的statement，用来执行具体的增删改查的
            SqlSession session = sqlSessionFactory.openSession();
            UserInfoMapper mapper=   session.getMapper(UserInfoMapper.class);

            List<UserInfo> userinfoes= mapper.selectUserByParams2("张","青");
            for (UserInfo user:userinfoes) {
                System.out.println(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test06() {
        try {
            String resource = "mybatis-config.xml";
//            读取配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
//            创建SqlSessionFactory实例
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//           SqlSession相当于JDBC中的statement，用来执行具体的增删改查的
            SqlSession session = sqlSessionFactory.openSession();
            UserInfoMapper mapper=   session.getMapper(UserInfoMapper.class);
            UserInfo user=new UserInfo();
            user.setUsername("尼古拉特斯拉");
            user.setUserpwd("123456");
            user.setUseraddress("大连");
            user.setUsertel("13698745698");
            user.setIsdelete(1);
            int num= mapper.insertSelective(user);
            session.commit();
            System.out.println(num);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test05() {
        try {
            String resource = "mybatis-config.xml";
//            读取配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
//            创建SqlSessionFactory实例
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//           SqlSession相当于JDBC中的statement，用来执行具体的增删改查的
            SqlSession session = sqlSessionFactory.openSession();
            UserInfoMapper mapper=   session.getMapper(UserInfoMapper.class);
            UserInfo userInfo=new UserInfo();
            userInfo.setUsername("张");
            userInfo.setUseraddress("青");
            List<UserInfo> userinfoes= mapper.selectUserInfoByLike(userInfo);
            for (UserInfo user:userinfoes) {
                System.out.println(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test04() {
        try {
            String resource = "mybatis-config.xml";
//            读取配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
//            创建SqlSessionFactory实例
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//           SqlSession相当于JDBC中的statement，用来执行具体的增删改查的
            SqlSession session = sqlSessionFactory.openSession();
            UserInfoMapper mapper=   session.getMapper(UserInfoMapper.class);

            List<Integer> ids=new ArrayList<>();
            ids.add(1);
            ids.add(2);
            ids.add(3);
            ids.add(4);
            List<UserInfo> userinfoes= mapper.selectUserInfoByIds(ids);
            for (UserInfo user:userinfoes
            ) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test03() {
        try {
            String resource = "mybatis-config.xml";
//            读取配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
//            创建SqlSessionFactory实例
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//           SqlSession相当于JDBC中的statement，用来执行具体的增删改查的
            SqlSession session = sqlSessionFactory.openSession();
            UserInfoMapper mapper=   session.getMapper(UserInfoMapper.class);
            UserInfo userInfo=new UserInfo();
            userInfo.setUsername("admin");
            userInfo.setUseraddress("青岛");

            List<UserInfo> userinfoes= mapper.selectUserInfo2(userInfo);
            for (UserInfo user:userinfoes) {
                System.out.println(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test02() {
        try {
            String resource = "mybatis-config.xml";
//            读取配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
//            创建SqlSessionFactory实例
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//           SqlSession相当于JDBC中的statement，用来执行具体的增删改查的
            SqlSession session = sqlSessionFactory.openSession();
            UserInfoMapper mapper=   session.getMapper(UserInfoMapper.class);
            UserInfo userInfo=new UserInfo();
//            userInfo.setUsername("admin");
//            userInfo.setUseraddress("青岛");

            List<UserInfo> userinfoes= mapper.selectUserInfo(userInfo);
            for (UserInfo user:userinfoes) {
                System.out.println(user);
            }

            System.out.println(userInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test01() {
        try {
            String resource = "mybatis-config.xml";
//            读取配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
//            创建SqlSessionFactory实例
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//           SqlSession相当于JDBC中的statement，用来执行具体的增删改查的
            SqlSession session = sqlSessionFactory.openSession();
            UserInfoMapper mapper=   session.getMapper(UserInfoMapper.class);

            UserInfo userInfo= mapper.selectByPrimaryKey(1);

            System.out.println(userInfo);
            System.out.println(userInfo.getUsername()+"    "+ userInfo.getUseraddress());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test08();
    }

}



