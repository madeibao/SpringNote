package com.example.demo;

import com.example.dao.UserDao;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName TestA
 * @Author：Mayuan
 * @Date 2022/2/26/0026 21:01
 * @Description TODO
 * @Version 1.0
 **/

@Controller
public class TestA {


    /**
     * Attributes===>
     */
    @Autowired
    private UserDao userDao;

    /**
     * Controller Operation===>
     */
    @GetMapping("/users/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") int id) {
        User user = userDao.getUserById(id);
        return user;
    }

    //	@GetMapping("/users/{id}")
    //	@ResponseBody
    //	@SuppressWarnings("rawtypes")
    //	public Map getUserMapById(@PathVariable("id") String id) {
    //		Map map = userDao.getMapById(Integer.parseInt(id));
    //		return map;
    //	}

    @GetMapping("/users")
    @ResponseBody
    @SuppressWarnings("rawtypes")
    public List getAllUser() {
        List list = userDao.getAllUser();
        return list;
    }

    @PostMapping("/users")
    @ResponseBody
    public String saveUser(@RequestBody User user) {
        String msg = userDao.saveUser(user);
        return msg;
    }

    @PatchMapping("/users/{id}")
    @ResponseBody
    public String updateUserPassword(@PathVariable("id") int id, @RequestBody String newPassword) {
        String msg = userDao.updateUserPassword(id, newPassword);
        return msg;
    }

    @DeleteMapping("/users/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") int id) {
        String msg = userDao.deleteUserById(id);
        return msg;
    }
}
