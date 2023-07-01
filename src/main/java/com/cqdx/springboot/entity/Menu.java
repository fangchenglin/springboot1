package com.cqdx.springboot.entity;

import java.io.Serializable;

/**
 * (Menu)实体类
 *
 * @author makejava
 * @since 2023-06-29 09:43:46
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = -72821127042460998L;
    
    private Long menuId;
    
    private String title;
    
    private String path;
    
    private String icon;
    
    private Long parentId;
    
    private String userType;


    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}

