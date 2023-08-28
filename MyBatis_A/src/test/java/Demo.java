/**
 * @ClassName Demo
 * @Author：Mayuan
 * @Date 2022/2/14/0014 22:20
 * @Description TODO
 * @Version 1.0
 **/


import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import com.mayuan.myTest.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * 类说明:
 *		第一个Mybatis程序:打印出数据库中的一条记录
 * @guoqianliang1998.
 */
public class Demo {

    @Test
    public void testSelectOne() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = sqlSessionFactory.openSession();

        try {
            User user = session.selectOne("test.sql1", 2);
            SimpleDateFormat df2 = new SimpleDateFormat("YYYY-MM-DD");
            System.out.println(user.getId()+"-"+user.getName()+"-"+user.getSex()+"-"+user.getAddress()+"-"+df2.format(user.getBirthday()));
        } finally {
            session.close();
        }
    }
}
