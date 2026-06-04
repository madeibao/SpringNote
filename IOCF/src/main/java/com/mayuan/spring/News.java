package com.mayuan.spring;

/**
 * @ClassName News
 * @Author：Mayuan
 * @Date 2022/1/22/0022 22:45
 * @Description TODO
 * @Version 1.0
 **/



public class News {
    String title;
    String content;

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News(String title, String content) {

        this.title = title;
        this.content = content;
    }

    public News() {

    }
}