package com.mayuan.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**o
 * @ClassName BookDa
 * @Author：Mayuan
 * @Date 2022/1/23/0023 20:36
 * @Description TODO
 * @Version 1.0
 *
 * 需要同步的改变
 * 也可以通过修改 Repository("bookHaHa");
 * Object bean = ioc.getBean("bookHaHa");
 **/

@Repository("bookDao")
@Scope(value = "singleton")
public class BookDao {

}
