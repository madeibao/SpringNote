package com.mayuan.test3;

import com.mayuan.mybatis.dao.StudentDao;
import com.mayuan.mybatis.entity.Student;
import com.mayuan.mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TestA
 * @Author：Mayuan
 * @Date 2023/8/31/0031 14:55
 * @Description TODO
 * @Version 1.0
 **/

/**
 * 这个案例用来学习 ${} 和 #{}的区别
 *
 *
 */
public class TestA {

    @Test
    public void testUpdateStudent() {
        SqlSession session= MyBatisUtil.createSqlsession();
        StudentDao studentDao=session.getMapper(StudentDao.class);
        Student student=new Student();
        student.setId(3);
        student.setName("最强王者");
        student.setEmail("123456@qq.com");
        student.setAge(28);
        int rows=studentDao.updateStudent(student);
        session.commit();
        System.out.println("更新学生的rows === " + rows);
        session.close();
    }


    /** 占位符号的使用 ${} */
    @Test
    public void testQueryStudent() {
        SqlSession session= MyBatisUtil.createSqlsession();
        StudentDao studentDao=session.getMapper(StudentDao.class);
        List<Student> students=studentDao.queryStudent("'张起灵'");
        for(Student stu : students) {
            System.out.println("stu === " + stu);
        }

        session.close();
    }

    /** 按照某一列来进行查询*/
    /**
     * ${}
     */
    @Test
    public void testQueryStudentOrderByColName() {
        SqlSession session= MyBatisUtil.createSqlsession();
        StudentDao studentDao=session.getMapper(StudentDao.class);
        List<Student> students=studentDao.queryStudentOrderByColName("张起灵","id","student");
        for(Student stu : students) {
            System.out.println("stu === " + stu);
        }
        session.close();
    }

    /**
     * 根据ID来进行查询
     * 此时，resultType使用了 Java类型的全限定名称。表示的意思是 mybatis 执行sql语句，
     * 把ResultSet中的数据转为 Student 类型的对象。mybatis会执行以下操作：
     *
     * 调用 com.bjpowernode.entity.Student 的无参构造方法，创建对象。（ Student student=new Student(); ）使用反射创建对象。
     * 同名的列赋值给同名的属性。例如：student.setId(rs.getInt("id"))；          student.setName(rs.getString("name"))；
     * 得到相应的Java对象（根据接口中方法的返回值类型而定，如果是List，则mybatis将Student对象放入List集合）。
     * 所以在测试方法中 Student student=studentDao.selectById(1003); 执行这行代码就会得到数据库中 id=1003 这行数据。
     *
     * 这行数据的列值赋给了student对象的属性，我们能得到student对象，就相当于是得到了 id=1003 这行数据。
     */
    @Test
    public void testSelectById() {
        SqlSession session = MyBatisUtil.createSqlsession();
        StudentDao studentDao=session.getMapper(StudentDao.class);
        Student student=studentDao.selectById(3);
        System.out.println("student === " + student);
        session.close();
    }

    @Test
    public void testCountStudent() {
        SqlSession session = MyBatisUtil.createSqlsession();
        StudentDao studentDao=session.getMapper(StudentDao.class);
        long nums=studentDao.countStudent();
        System.out.println("nums = " + nums);
        session.close();
    }

    @Test
    public void testSelectMap() {
        SqlSession session = MyBatisUtil.createSqlsession();
        StudentDao studentDao=session.getMapper(StudentDao.class);
        List<Map<Object,Object>> resList =studentDao.selectMap(1);
        resList.forEach(System.out::println);
        session.close();
    }
}

// 参考
//https://szh-forever-young.blog.csdn.net/article/details/114284448
