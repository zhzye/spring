package com.zhzye.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PersonBeforeAdvice {
    @Before(value = "execution(* sa*(..))")
    public void before() {
        System.out.println("before注入");
    }
}
