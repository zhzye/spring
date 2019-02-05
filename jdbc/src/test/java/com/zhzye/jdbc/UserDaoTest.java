package com.zhzye.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoTest {
    @Resource
    private UserDao studentDao;

    @Test
    public void getUsersCount() {
        Integer ret = studentDao.getUsersCount();
        System.out.println("user count = " + ret);
    }

    @Test
    public void saveStudentAndClassWithOpenTx() {
        studentDao.saveStudentAndClassWithOpenTx();
    }

    @Test
    public void createTable() {
        studentDao.createTables();
    }

    @Test
    public void dropTables() {
        studentDao.dropTables();
    }
}
