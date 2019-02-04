package com.zhzye.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PersonBeforeAdvice {
    @Before(value = "execution(* sa*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("before注入" + joinPoint);
    }

    @AfterReturning(value = "execution(* sa*(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("after注入 " + joinPoint);
    }
}
