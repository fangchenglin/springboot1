package com.cqdx.springboot.aop;

import com.cqdx.springboot.utils.result.DataResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * @version V1.0
 * @author: hepeng
 * @Title: AroundCut.java
 * @Package:
 * @description:
 * @date: 2023/6/28 10:12
 */
@Component
@Aspect
public class AroundCut {
    public static final String POINT_CUT = "execution(* com.cqdx.springboot.controller.StudentController.*(..)) || " +
            "execution(* com.cqdx.springboot.controller.MenuController.*(..)) || " +
            "execution(* com.cqdx.springboot.controller.UserController.*(..)) || " +
            "execution(* com.cqdx.springboot.controller.LoginController.*(..))";



    @Around(AroundCut.POINT_CUT)
    public DataResult checkSession(ProceedingJoinPoint pjp) throws Throwable {
        //获取session
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        return (DataResult) pjp.proceed();
    }
}
