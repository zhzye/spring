package com.zhzye.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserDaoProxy implements InvocationHandler {
    private UserDao userDao;
    public UserDaoProxy(UserDao userDao) {
        this.userDao = userDao;
    }
    public Object createProxy() {
        return Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(userDao, args);
    }
}
