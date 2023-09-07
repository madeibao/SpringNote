package com.candy.demo.bean;

/**
 * @ClassName UserInfo
 * @Author：Mayuan
 * @Date 2023/9/7/0007 15:27
 * @Description TODO
 * @Version 1.0
 **/
public class UserInfo {
    private Integer id;

    private String username;

    private String userpwd;

    private String useraddress;

    private String usertel;

    private Integer isdelete;

    private String imgsrc;

    public UserInfo(Integer id, String username, String userpwd, String useraddress, String usertel, Integer isdelete, String imgsrc) {
        this.id = id;
        this.username = username;
        this.userpwd = userpwd;
        this.useraddress = useraddress;
        this.usertel = usertel;
        this.isdelete = isdelete;
        this.imgsrc = imgsrc;
    }

    public UserInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress == null ? null : useraddress.trim();
    }

    public String getUsertel() {
        return usertel;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel == null ? null : usertel.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc == null ? null : imgsrc.trim();
    }
}