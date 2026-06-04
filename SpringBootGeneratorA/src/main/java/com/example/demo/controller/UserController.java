package com.example.demo.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.util.JsonData;

import com.example.demo.service.IUserService;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mayuan
 * @since 2023-09-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 查询所有接口
     * @return
     */
    @GetMapping
    public JsonData findAll() {
            return JsonData.buildSuccess(userService.list());
    }
    /**
     * 根据id查询数据接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public JsonData findOne(@PathVariable Integer id) {
            return JsonData.buildSuccess(userService.getById(id));
            }
    /**
     * 分页查询接口
     * @param pageNum
     * @param pageSize
     * @return
     */


    @GetMapping("/page")
    public JsonData findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            return JsonData.buildSuccess(userService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }


    /**
     * 新增和更新接口
     * @param user
     * @return
     */
    @PostMapping
    public JsonData save(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return JsonData.buildSuccess();
    }

    /**
     * 删除接口
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public JsonData delete(@PathVariable Integer id) {
        userService.removeById(id);
            return JsonData.buildSuccess();
    }

    /**
     * 批量删除接口
     * @param ids
     * @return
     */
    @PostMapping("/del/batch")
    public JsonData deleteBatch(@RequestBody List<Integer> ids) {
            userService.removeByIds(ids);
            return JsonData.buildSuccess();
    }
}
