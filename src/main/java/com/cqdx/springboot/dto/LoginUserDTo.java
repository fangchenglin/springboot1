package com.cqdx.springboot.dto;

import com.cqdx.springboot.entity.Menu;
import com.cqdx.springboot.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * @version V1.0
 * @author: hepeng
 * @Title: LoginUserDTo.java
 * @Package:
 * @description:
 * @date: 2023/6/29 09:47
 */
public class LoginUserDTo implements Serializable {

    private User user;
    private List<Menu> menus;

    public LoginUserDTo() {
    }

    public LoginUserDTo(User user, List<Menu> menus) {
        this.user = user;
        this.menus = menus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "LoginUserDTo{" +
                "user=" + user +
                ", menus=" + menus +
                '}';
    }
}
