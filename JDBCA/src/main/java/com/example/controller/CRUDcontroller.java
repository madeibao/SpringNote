package com.example.controller;

import com.example.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.pojo.User;


/**
 * @ClassName CRUDcontroller
 * @Author：Mayuan
 * @Date 2022/2/19/0019 19:59
 * @Description TODO
 * @Version 1.0
 **/

@Controller
public class CRUDcontroller {

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

}// End of Class
