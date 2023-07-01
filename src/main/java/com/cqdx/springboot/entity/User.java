package com.cqdx.springboot.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2023-06-29 09:43:13
 */
public class User implements Serializable {
    private static final long serialVersionUID = -41020089407408949L;
    
    private Long userId;
    
    private String username;
    
    private String password;
    /**
     * 1.学生 2.老师
     */
    private Integer userType;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

}

