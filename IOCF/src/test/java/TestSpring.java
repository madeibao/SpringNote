import com.mayuan.spring.News;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestSpring
 * @Author：Mayuan
 * @Date 2022/1/22/0022 22:58
 * @Description TODO
 * @Version 1.0
 **/


public class TestSpring {
    private ClassPathXmlApplicationContext ctx;

    @Before
    public void before() {
        //初始化Spring容器，当Spring容器初始化时，会自动加载配置文件，然后根据配置文件中的内容初始化Bean
        ctx = new ClassPathXmlApplicationContext("application.xml");
    }

    @Test
    public void test1() {
        News news11 = (News) ctx.getBean("news11");
        System.out.println(news11);
        News news12 = (News) ctx.getBean("news12");
        System.out.println(news12);
    }

    @Test
    public void test2() {
        News news21 = (News) ctx.getBean("news21");
        System.out.println(news21);
        News news22 = (News) ctx.getBean("news22");
        System.out.println(news22);
    }
}
