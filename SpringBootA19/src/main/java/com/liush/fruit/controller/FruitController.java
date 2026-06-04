package com.liush.fruit.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liush.fruit.config.Result;
import com.liush.fruit.mapper.FruitMapper;
import com.liush.fruit.model.Fruit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

/**
 * @ClassName FruitController
 * @Author：Mayuan
 * @Date 2023/8/27/0027 20:57
 * @Description TODO
 * @Version 1.0
 **/
@Controller
@Slf4j
public class FruitController {

    @Autowired
    private FruitMapper fruitMapper;

    @RequestMapping("/index")
    public String index(@RequestParam(name = "cunPage", defaultValue = "1") Integer cunPage,
                        @RequestParam(name = "size", defaultValue = "4") Integer size, Model model) {
        Page<Map<String, Object>> page = new Page<>(cunPage, size);
        fruitMapper.selectMapsPage(page, null);
        List<Map<String, Object>> fruits = page.getRecords();
        model.addAttribute("fruits", fruits);
        model.addAttribute("page", page);
        return "index.html";
    }

    @RequestMapping("/add")
    @ResponseBody
    public Object add(@RequestParam(name = "name", required = true) String name,
                      @RequestParam(name = "price", required = true) Integer price,
                      @RequestParam(name = "count", required = true) Integer count) {
        Fruit fruit = new Fruit();
        fruit.setName(name);
        fruit.setPrice(price);
        fruit.setCount(count);
        int num = fruitMapper.insert(fruit);
        if (num != 1) {
            return Result.error("添加失败");
        }
        return Result.success("添加成功");
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id", required = true) Integer id, Model model) {
        Fruit fruit = fruitMapper.selectById(id);
        model.addAttribute("fruit", fruit);
        return "edit.html";
    }

    @PostMapping("/update")
    public String update(@RequestParam(name = "fid", required = true) Integer fid,
                         @RequestParam(name = "fname", required = true) String fname,
                         @RequestParam(name = "fprice", required = true) Integer fprice,
                         @RequestParam(name = "fcount", required = true) Integer fcount) {
        Fruit fruit = new Fruit();
        fruit.setId(fid);
        fruit.setName(fname);
        fruit.setPrice(fprice);
        fruit.setCount(fcount);
        int num = fruitMapper.updateById(fruit);
        if (num != 1) {
            System.out.println("更新失败");
        }
        return "redirect:/index";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(@RequestParam(name = "id", required = true) Integer id) {
        int num = fruitMapper.deleteById(id);
        if (num != 1) {
            return Result.error("删除失败");
        }
        return Result.success("删除成功");
    }
}
