
import com.jiuqi.springjdbc.entity.User;
import com.jiuqi.springjdbc.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author JiuQi 玖柒
 * @date 2021/5/13 19:18
 */
public class JdbcTemplateTest {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring.xml");
//        UserDao userDao = beanFactory.getBean(UserDao.class);
//        List<User> users = userDao.sel();
        UserService userService = beanFactory.getBean(UserService.class);
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}


//User{id=1, name='admin', pwd='123456', birthday=2000-12-04, age=23}
//User{id=2, name='manager', pwd='123456', birthday=2000-12-04, age=23}
//User{id=3, name='admin2', pwd='1234567', birthday=1995-08-11, age=25}