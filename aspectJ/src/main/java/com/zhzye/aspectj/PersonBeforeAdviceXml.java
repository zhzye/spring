package com.zhzye.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class PersonBeforeAdviceXml {
    public void before(JoinPoint joinPoint) {
        System.out.println("before注入..." + joinPoint);
    }

    public void after(JoinPoint joinPoint, Object result) {
        System.out.println("after注入... " + joinPoint + " " + result);
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕===before");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("环绕===after");
        return object;
    }

    public void afterThrow(Throwable e) {
        System.out.println("异常抛出通知 e " + e.getMessage());
    }

    public void finalDO() {
        System.out.println("最终通知");
    }
}
