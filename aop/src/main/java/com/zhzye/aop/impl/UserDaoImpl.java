package com.zhzye.aop.impl;

import com.zhzye.aop.UserDao;

public class UserDaoImpl implements UserDao {
    public void saveUser() {
        System.out.println("save user");
    }

    public void updateUser() {
        System.out.println("update user");
    }

    public void getUser() {
        System.out.println("get user");
    }

    public void deleteUser() {
        System.out.println("delete user");
    }
}
