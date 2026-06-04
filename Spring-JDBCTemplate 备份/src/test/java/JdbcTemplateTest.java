import com.jiuqi.springjdbc.dao.UserDao;
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
