import com.sp.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        IUserService userService=context.getBean("userService", IUserService.class);
        userService.add();
        userService.delete();
        userService.select();
        userService.update();
    }
}
