package com.cqdx.springboot.controller;

import com.cqdx.springboot.entity.User;
import com.cqdx.springboot.service.UserService;
import com.cqdx.springboot.utils.result.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @version V1.0
 * @author: hepeng
 * @Title: LoginController.java
 * @Package:
 * @description:
 * @date: 2023/6/29 09:51
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping("login")
    public DataResult login(@RequestBody User user){
        return userService.loginUser(user);
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @PostMapping("loginOut")
    public DataResult loginOut(HttpSession session){
        session.invalidate();
        return DataResult.succ();
    }

}
