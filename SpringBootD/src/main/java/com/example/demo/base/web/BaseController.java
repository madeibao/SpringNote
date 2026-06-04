package com.example.demo.base.web;

import com.example.demo.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName BaseController
 * @Author：Mayuan
 * @Date 2023/8/15/0015 10:39
 * @Description TODO
 * @Version 1.0
 **/
public abstract class BaseController<S extends BaseService,T> {
    @Autowired
    S service;

    public abstract String getPerfix();

    @RequestMapping
    public String list(ModelMap map){
        map.put("entityList",service.findList());
        return getPerfix()+"/list";
    }

    @GetMapping("add")
    public String add(){
        return getPerfix()+"/add";
    }


    @PostMapping("add")
    public String add(T entity){
        service.save(entity);
        return "redirect:"+getPerfix();
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap map){
        map.put("entity",service.findById(id));
        return getPerfix()+"/edit";
    }


    @PostMapping("edit")
    public String edit(T entity){
        service.update(entity);
        return "redirect:"+getPerfix();
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        service.delete(id);
        return "redirect:"+getPerfix();
    }
}
