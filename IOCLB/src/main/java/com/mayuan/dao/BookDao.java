package com.mayuan.dao;

/**
 * @ClassName BookDao
 * @Author：Mayuan
 * @Date 2022/1/23/0023 22:54
 * @Description TODO
 * @Version 1.0
 **/
import org.springframework.stereotype.Repository;



/**
 * 这个类的id就是默认类名的首字母小写。bookDao就是这个类的id。
 * 可以在注解后面写括号，来改组件的名字。
 * @Scope(value = "prototype")//修改这个实例为多实例。
 */

//@Repository("bookha")
//@Scope(value = "prototype")

@Repository
public class BookDao {

    public void saveBook(){
        System.out.println("图书已经被保存！");
    }
}
