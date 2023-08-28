import com.aop.aspect.annotation.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * @ClassName TestAOP
 * @Author：Mayuan
 * @Date 2022/4/4/0004 20:41
 * @Description TODO
 * @Version 1.0
 **/
@ContextConfiguration(locations = "classpath:/aspectA.xml")
public class TestAOP {
    @Test
    public void testAnnotation() {
        //1.加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("aspectA.xml");
        //2.获取User的bean对象
        User user = context.getBean("user", User.class);
        //3.User的bean对象调用方法
        user.add();//输出：前置通知：before方法|add方法
    }
}