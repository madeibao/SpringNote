package com.wjb;

import static org.junit.Assert.assertTrue;

import com.wjb.face.service.BookService;
import com.wjb.face.service.UserService;
import com.wjb.face.service.studentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testServices() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.say();
        BookService bookService = (BookService) ctx.getBean("bookService");
//        bookService.show(10, 20);
        studentService ss = (studentService) ctx.getBean("studentService");
//        ss.save();
    }
}
