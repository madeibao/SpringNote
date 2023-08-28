package edu.neu;

import edu.neu.service.BooksService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BooksTest {
    @Test
    public void queryAllBooks(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksService service= (BooksService) applicationContext.getBean("BooksServiceImpl");
        service.queryAllBooks().stream().forEach(System.out::println);
    }
}
