package com.zhzye.aop;

import com.zhzye.aop.impl.UserDaoImpl;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void userDao() {
        UserDao userDao = new UserDaoImpl();
        userDao.saveUser();
        userDao.deleteUser();
        userDao.updateUser();
        userDao.getUser();
    }

    @Test
    public void userDaoProxy() {
        UserDao userDao = new UserDaoImpl();
        UserDao proxy = (UserDao) new UserDaoProxy(userDao).createProxy();
        proxy.saveUser();
        proxy.deleteUser();
        proxy.updateUser();
        proxy.getUser();
    }

    @Test
    public void userDaoCGLibProxy() {
        UserDaoWithoutInterface userDao = new UserDaoWithoutInterface();
        UserDaoWithoutInterface proxy = (UserDaoWithoutInterface) new UserDaoCGLibProxy(userDao).createProxy();
        proxy.saveUser();
        proxy.getUser();
    }
}
