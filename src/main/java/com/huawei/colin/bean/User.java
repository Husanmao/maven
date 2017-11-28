package com.huawei.colin.bean;

import java.io.Serializable;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 2017/11/28
 */
public class User implements Serializable {

    private String username;

    private String passwd;

    public User(String username, String passwd) {
        this.passwd = passwd;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Username : " + username + ", Passwd : " + passwd;
    }
}
