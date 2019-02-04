package com.zhzye.aop;

import com.zhzye.aop.auto.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TeacherAutoTest {
    @Autowired
    private Teacher teacher;

    @Test
    public void autoProxyFactoryBean() {
        teacher.down();
        teacher.hi();
    }
}
