package com.zhzye.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentDaoTest {
    @Resource
    private StudentDao studentDao;

    @Test
    public void getStudentCount() {
        Integer ret = studentDao.getStudentCount();
        System.out.println("user count = " + ret);
    }
}
