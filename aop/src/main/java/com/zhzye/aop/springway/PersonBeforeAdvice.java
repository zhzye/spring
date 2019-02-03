package com.zhzye.aop.springway;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class PersonBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("before advice增强");
    }
}
