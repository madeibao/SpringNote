package cn.nnxy.mybatisplustest.controller;

import cn.nnxy.mybatisplustest.entity.User;
import cn.nnxy.mybatisplustest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author huangjianquan
 * @date 2022/9/30
 **/
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取全部
     * @return
     */
    @RequestMapping("/getUser")
    @ResponseBody
    public List<User> userList() {
        List<User> list = userService.list();
        return list;
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    @RequestMapping("/getUserById/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        return user;
    }

    /**
     * 添加
     * @return
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser() {
        User user1 = new User();
        user1.setId(4);
        user1.setName("xiaoming");
        user1.setSchool("上海交通大学");
        userService.save(user1);
        return "添加成功";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteUser/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.removeById(id);
        return "删除成功";
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser() {
        User user2 = new User();
        user2.setId(4);
        user2.setName("大明");
        user2.setSchool("上海交通大学");
        userService.saveOrUpdate(user2);
        return "修改成功";
    }
}
