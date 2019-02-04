package com.zhzye.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class PersonBeforeAdvice {
    @Before(value = "sayPointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before注入..." + joinPoint);
    }

    @AfterReturning(value = "sayPointcut()", returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        System.out.println("after注入... " + joinPoint + " " + result);
    }

    @Around(value = "execution(* hi(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕===before");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("环绕===after");
        return object;
    }

    @AfterThrowing(value = "execution(* exeThrowException(..))", throwing = "e")
    public void afterThrow(Throwable e) {
        System.out.println("异常抛出通知 e " + e.getMessage());
    }

    @After(value = "execution(* exeThrowException(..))")
    public void finalDO() {
        System.out.println("最终通知");
    }

    @Pointcut(value = "execution(* say(..))")
    private void sayPointcut() {}
}
