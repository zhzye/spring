package com.zhzye.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 这种proxy使用了cglib
 * 属于字节码增强技术
 * 目前cglib的支持在spring组件中
 */
public class UserDaoCGLibProxy implements MethodInterceptor {
    private final Object object;

    public UserDaoCGLibProxy(Object object) {
        this.object = object;
    }

    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        Object proxy = enhancer.create();
        return proxy;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("saveUser")) {
            System.out.println("save user 增强");
        }
        return methodProxy.invokeSuper(o, objects);
    }
}
