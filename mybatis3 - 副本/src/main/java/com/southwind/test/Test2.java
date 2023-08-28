package com.southwind.test;

import com.southwind.entity.Account;
import com.southwind.repository.AccountRepository;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * @ClassName Test2
 * @Author：Mayuan
 * @Date 2020/12/24/0024 21:50
 * @Description TODO
 * @Version 1.0
 **/
public class Test2 {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取实现接⼝口的代理理对象
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);

//
//        // 添加对象。
//        Account account = new Account(3L,"王五","111111",24);
//        int result = accountRepository.save(account);
//        sqlSession.commit();


//         List<Account> list = accountRepository.findAll();
//         for (Account account:list) {
//         System.out.println(account);
//         }
//         sqlSession.close();
//

            //通过id查询对象
//         Account account = accountRepository.findById(44L);
//         System.out.println(account);
//         sqlSession.close();


        //修改对象
//         Account account = accountRepository.findById(44L);
//         account.setUsername("⼩小明");
//         account.setPassword("000");
//         account.setAge(18);
//         int result = accountRepository.update(account);
//         sqlSession.commit();
//         System.out.println(result);
//         sqlSession.close();


        //通过id删除对象
        int result = accountRepository.deleteById(47L);
        System.out.println(result);
        sqlSession.commit();
        sqlSession.close();
    }
}
