package com.yongli.demo.bean;

import java.io.Serializable;

/**
 * @ClassName Permission
 * @Author：Mayuan
 * @Date 2023/9/6/0006 20:32
 * @Description TODO
 * @Version 1.0
 **/
public class Permission implements Serializable {

    private static final long serialVersionUID = 6180869216498363919L;

    private Long parentId;
    private String name;
    private String css;
    private String href;
    private Integer type;
    private String permission;
    private Integer sort;



    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


}
