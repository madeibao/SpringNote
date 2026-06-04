package cn.chenjiajin.service.impl;

/**
 * @ClassName MybatisDoubleCacheTest
 * @Author：Mayuan
 * @Date 2023/8/30/0030 18:13
 * @Description TODO
 * @Version 1.0
 **/

import cn.chenjiajin.domain.User;
import cn.chenjiajin.mapper.UserMapper;
import cn.chenjiajin.service.IUserService;
import cn.chenjiajin.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * 二级缓存测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisDoubleCacheTest {

    @Autowired
    private IUserService service;

    /**
     * 测试一级缓存的存在
     * 一级缓存是SqlSession级别的缓存  SqlSession间隔离 ；
     * 测试使用同一个 SqlSession对象，查看重复查询是否会多次发送SQL语句
     */
    @Test
    public void testLevelOneExist() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.err.println("--------------开始第一次查询---------------------");
        User user1 = mapper.findById(1);
        System.err.println("------------第一次查询结束开始第二次查询-----------------------");
        User user2 = mapper.findById(1);
        System.err.println("------------ 第二次查询结束-----------------------");
        System.err.println("两次查询出来的对象 user1 user2 是否相等 ： " + (user1 == user2));

        /*
          --------------开始第一次查询---------------------
          DEBUG [main] - ==>  Preparing: select * from user where id = ?
          DEBUG [main] - ==> Parameters: 1(Integer)
          TRACE [main] - <==    Columns: id, name, age
          TRACE [main] - <==        Row: 1, lucy, 123
          DEBUG [main] - <==      Total: 1
          ------------第一次查询结束开始第二次查询-----------------------
          ------------ 第二次查询结束-----------------------
          两次查询出来的对象 user1 user2 是否相等 ： true
         */
        // 参数相同 , 只查一次

    }


    /**
     * 测试一级缓存销毁触发条件
     * 同一个SqlSession的两次查询中间，增加一个增加、删除或修改操作并提交事务
     */
    @Test
    public void testLevelOneInvalid() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.err.println("--------------开始第一次查询---------------------");
        User user1 = mapper.findById(1);
        System.err.println("------------第一次查询结束-----------------------");
        User user = new User();
        user.setId(3);
        user.setName("Kay");
        System.err.println("------------开始执行 insert、update、delete 操作 并提交事务-----------------------");
        mapper.updateName(user);
        //userMapper.insertOne(user);
        //userMapper.deleteById(3);
        sqlSession.commit();
        System.err.println("------------开始第二次查询-----------------------");
        User user2 = mapper.findById(1);
        System.err.println("------------ 第二次查询结束-----------------------");
        System.err.println("两次查询出来的对象 user1 user2 是否相等 ： " + (user1 == user2));

        /*
          --------------开始第一次查询---------------------
          DEBUG [main] - ==>  Preparing: select * from user where id = ?
          DEBUG [main] - ==> Parameters: 1(Integer)
          TRACE [main] - <==    Columns: id, name, age
          TRACE [main] - <==        Row: 1, lucy, 123
          DEBUG [main] - <==      Total: 1
          ------------第一次查询结束-----------------------
          ------------开始执行 insert、update、delete 操作 并提交事务-----------------------
          DEBUG [main] - ==>  Preparing: update user set name = ? where id = ?
          DEBUG [main] - ==> Parameters: Kay(String), 3(Integer)
          DEBUG [main] - <==    Updates: 0
          ------------开始第二次查询-----------------------
          DEBUG [main] - ==>  Preparing: select * from user where id = ?
          DEBUG [main] - ==> Parameters: 1(Integer)
          TRACE [main] - <==    Columns: id, name, age
          TRACE [main] - <==        Row: 1, lucy, 123
          DEBUG [main] - <==      Total: 1
          ------------ 第二次查询结束-----------------------
          两次查询出来的对象 user1 user2 是否相等 ： false
         */
    }

    /**
     * 测试二级缓存是否存在
     */
    @Test
    public void testLevelTwoExist() throws Exception {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession1 = factory.openSession();
        SqlSession sqlSession2 = factory.openSession();
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);    // 两个连接对象都是用的同一个namespace  , namespace = cn.chenjiajin.mapper.UserMapper
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);

        System.err.println("--------------执行SqlSession1 创建的UserMapper1 对象的查询---------------------");
        User user1 = userMapper1.findById(1);
        sqlSession1.close(); // 查询后关闭sqlSession1 , 否则二级缓存也不会生效
        // 因为关闭sqlSession1的时候就是进行缓存的时刻(内存-->磁盘),不关闭将不会产生二级缓存数据
        // 触发将对象(一级缓存的数据) 写入二级缓存的时机： SqlSession对象的close()方法

        System.err.println("--------------执行SqlSession2 创建的UserMapper2 对象的查询---------------------");
        User user2 = userMapper2.findById(1);
        sqlSession2.close();

        System.err.println("两次查询出来的对象 user1 user2 是否相等 ： " + (user1 == user2));

        /*
          --------------执行SqlSession1 创建的UserMapper1 对象的查询---------------------
          DEBUG [main] - Cache Hit Ratio [cn.chenjiajin.mapper.UserMapper]: 0.0                第一次查询,二级缓存中没有数据,不命中缓存,命中率为0
          DEBUG [main] - ==>  Preparing: select * from user where id = ?
          DEBUG [main] - ==> Parameters: 1(Integer)
          TRACE [main] - <==    Columns: id, name, age
          TRACE [main] - <==        Row: 1, lucy, 123
          DEBUG [main] - <==      Total: 1
          --------------执行SqlSession2 创建的UserMapper2 对象的查询---------------------
          DEBUG [main] - Cache Hit Ratio [cn.chenjiajin.mapper.UserMapper]: 0.5                第二次查询,二级缓存中存在数据,命中缓存,两次查询的总命中率为50%
          两次查询出来的对象 user1 user2 是否相等 ： false
         */

        // 注意: 开启二级缓存需要实体类序列化
        // 否则报异常org.apache.ibatis.cache.CacheException: Error serializing object.  Cause: java.io.NotSerializableException: cn.chenjiajin.domain.User

    }


    /**
     * 测试二级缓存被删除
     */
    @Test
    public void testLevelTwoInvalid() throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession1 = factory.openSession();
        SqlSession sqlSession2 = factory.openSession();
        SqlSession sqlSession3 = factory.openSession(true);

        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);

        System.err.println("--------------执行SqlSession1创建的UserMapper1对象的查询---------------------");
        User user1 = userMapper1.findById(1);
        sqlSession1.close();            // 查询后关闭sqlSession1

        System.err.println("--------------执行SqlSession3创建的UserMapper3对象的增删改操作---------------------");
        User user = new User();
        user.setAge(8);
        user.setName("sunshineKay");
        userMapper3.insert(user);       // 插入后关闭sqlSession3
        sqlSession3.close();

        System.err.println("--------------执行SqlSession2创建的UserMapper2对象的查询---------------------");
        User user2 = userMapper2.findById(1);
        sqlSession2.close();

        System.err.println("两次查询出来的对象 user1 user2 是否相等 ： " + (user1 == user2));

        /*
          --------------执行SqlSession1创建的UserMapper1对象的查询---------------------
          DEBUG [main] - Cache Hit Ratio [cn.chenjiajin.mapper.UserMapper]: 0.0
          DEBUG [main] - ==>  Preparing: select * from user where id = ?
          DEBUG [main] - ==> Parameters: 1(Integer)
          TRACE [main] - <==    Columns: id, name, age
          TRACE [main] - <==        Row: 1, lucy, 123
          DEBUG [main] - <==      Total: 1
          --------------执行SqlSession3创建的UserMapper3对象的增删改操作---------------------
          DEBUG [main] - ==>  Preparing: insert into user (name) values (?)
          DEBUG [main] - ==> Parameters: sunshineKay(String)
          DEBUG [main] - <==    Updates: 1
          --------------执行SqlSession2创建的UserMapper2对象的查询---------------------
          DEBUG [main] - Cache Hit Ratio [cn.chenjiajin.mapper.UserMapper]: 0.0
          DEBUG [main] - ==>  Preparing: select * from user where id = ?
          DEBUG [main] - ==> Parameters: 1(Integer)
          TRACE [main] - <==    Columns: id, name, age
          TRACE [main] - <==        Row: 1, lucy, 123
          DEBUG [main] - <==      Total: 1
          两次查询出来的对象 user1 user2 是否相等 ： false         数据被修改之后 , 默认会不使用二级缓存的数据,再次去发SQL到数据库查询
         */
    }

    /**
     * 测试二级缓存 当某个update设置 flushCache="false" 即更新后不刷新缓存
     * 默认会刷新缓存 , 可以设置flushCache="false" 即更新后不刷新缓存
     */
    @Test
    public void testLevelTwoFlushCache() throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession1 = factory.openSession();
        SqlSession sqlSession2 = factory.openSession();
        SqlSession sqlSession3 = factory.openSession(true);

        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);

        System.err.println("--------------执行SqlSession1创建的UserMapper1对象的查询---------------------");
        User user1 = userMapper1.findById(1);
        System.err.println("id 为 1 的对象" + user1);
        sqlSession1.close(); // 查询后关闭sqlSession1

        System.err.println("--------------执行SqlSession3创建的UserMapper3对象的增删改操作---------------------");
        User user = new User();
        user.setId(1);
        user.setName("sunshineKay");
        userMapper3.updateNameNotFlush(user);// 插入后关闭sqlSession3
        sqlSession3.close();
        System.err.println("更新后id为1 的用户用户名 ： " + "sunshineKay");

        System.err.println("--------------执行SqlSession2创建的UserMapper2对象的查询---------------------");
        User user2 = userMapper2.findById(1);
        System.err.println("查询id 为 1 的对象 " + user2);
        sqlSession2.close();


        System.err.println("两次查询出来的对象 user1 user2 是否相等 ： " + (user1 == user2));

        /*
          --------------执行SqlSession1创建的UserMapper1对象的查询---------------------
          DEBUG [main] - Cache Hit Ratio [cn.chenjiajin.mapper.UserMapper]: 0.0
          DEBUG [main] - ==>  Preparing: select * from user where id = ?
          DEBUG [main] - ==> Parameters: 1(Integer)
          TRACE [main] - <==    Columns: id, name, age
          TRACE [main] - <==        Row: 1, askjdh, 123
          DEBUG [main] - <==      Total: 1
          id 为 1 的对象User(id=1, name=askjdh, age=123)                       // 第一次查询name = askjdh
          --------------执行SqlSession3创建的UserMapper3对象的增删改操作---------------------
          DEBUG [main] - ==>  Preparing: update user set name = ? where id = ?
          DEBUG [main] - ==> Parameters: sunshineKay(String), 1(Integer)
          DEBUG [main] - <==    Updates: 1
          更新后id为1 的用户用户名 ： sunshineKay
          --------------执行SqlSession2创建的UserMapper2对象的查询---------------------
          DEBUG [main] - Cache Hit Ratio [cn.chenjiajin.mapper.UserMapper]: 0.5
          查询id 为 1 的对象 User(id=1, name=askjdh, age=123)                   // 第二次查询name = askjdh,可以看到还是旧的缓存数据,但是数据库的数据被更新了
          两次查询出来的对象 user1 user2 是否相等 ： false
         */
    }

    /**
     * 测试二级缓存是否存在 注解的方式
     */
    @Test
    public void testLevelTwoExistAnnotation() throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = factory.openSession();
        SqlSession sqlSession2 = factory.openSession();
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);

        System.err.println("--------------执行SqlSession1创建的UserMapper1对象的查询---------------------");
        User user1 = userMapper1.findByIdNotCache(1);
        sqlSession1.close();

        System.err.println("--------------执行SqlSession2创建的UserMapper2对象的查询---------------------");
        User user2 = userMapper2.findByIdNotCache(1);
        sqlSession1.close();

        System.err.println("两次查询出来的对象 user1 user2 是否相等 ： " + (user1 == user2));

        /*
          --------------执行SqlSession1创建的UserMapper1对象的查询---------------------
          DEBUG [main] - ==>  Preparing: select * from user where id = ?
          DEBUG [main] - ==> Parameters: 1(Integer)
          TRACE [main] - <==    Columns: id, name, age
          TRACE [main] - <==        Row: 1, sunshineKay, 123
          DEBUG [main] - <==      Total: 1
          --------------执行SqlSession2创建的UserMapper2对象的查询---------------------
          DEBUG [main] - ==>  Preparing: select * from user where id = ?
          DEBUG [main] - ==> Parameters: 1(Integer)
          TRACE [main] - <==    Columns: id, name, age
          TRACE [main] - <==        Row: 1, sunshineKay, 123
          DEBUG [main] - <==      Total: 1
          两次查询出来的对象 user1 user2 是否相等 ： false
         */
    }

    /**
     * 测试二级缓存 当某个update设置 flushCache="false" 即更新后不刷新缓存
     */
    @Test
    public void testLevelTwoFlushCacheAnnotation() throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession1 = factory.openSession();
        SqlSession sqlSession2 = factory.openSession();
        SqlSession sqlSession3 = factory.openSession(true);

        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);

        System.err.println("--------------执行SqlSession1创建的UserMapper1对象的查询---------------------");
        User user1 = userMapper1.findByIdNotCache(1);
        System.err.println("id 为 1 的对象" + user1);
        sqlSession1.close(); // 查询后关闭sqlSession1

        System.err.println("--------------执行SqlSession3创建的UserMapper3对象的增删改操作---------------------");
        User user = new User();
        user.setId(1);
        user.setName("MM");
        userMapper3.updateName(user);   // 当查询的SQL不使用缓存的时候 , update是否刷新缓存都一样 , 反正都会去发SQL到数据库查询
        sqlSession3.close();

        System.err.println("更新后id为1 的用户用户名 ： MM");
        System.err.println("--------------执行SqlSession2创建的UserMapper2对象的查询---------------------");
        User user2 = userMapper2.findByIdNotCache(1);
        System.err.println("查询id 为 1 的对象 " + user2);
        sqlSession2.close();

        System.err.println("两次查询出来的对象 user1 user2 是否相等 ： " + (user1 == user2));

        /*
          --------------执行SqlSession1创建的UserMapper1对象的查询---------------------
          DEBUG [main] - ==>  Preparing: select * from user where id = ?
          DEBUG [main] - ==> Parameters: 1(Integer)
          TRACE [main] - <==    Columns: id, name, age
          TRACE [main] - <==        Row: 1, sunshineKay, 123
          DEBUG [main] - <==      Total: 1
          id 为 1 的对象User(id=1, name=sunshineKay, age=123)                  // 第一次查询 name = sunshineKay
          --------------执行SqlSession3创建的UserMapper3对象的增删改操作---------------------
          DEBUG [main] - ==>  Preparing: update user set name = ? where id = ?
          DEBUG [main] - ==> Parameters: MM(String), 1(Integer)
          DEBUG [main] - <==    Updates: 1
          更新后id为1 的用户用户名 ： MM
          --------------执行SqlSession2创建的UserMapper2对象的查询---------------------
          DEBUG [main] - ==>  Preparing: select * from user where id = ?
          DEBUG [main] - ==> Parameters: 1(Integer)
          TRACE [main] - <==    Columns: id, name, age
          TRACE [main] - <==        Row: 1, MM, 123
          DEBUG [main] - <==      Total: 1
          查询id 为 1 的对象 User(id=1, name=MM, age=123)             // 第二次查询 name = MM ,没有使用缓存(缓存被刷新) 而是去查数据库
          两次查询出来的对象 user1 user2 是否相等 ： false
         */

    }


}