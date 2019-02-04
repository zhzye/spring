package com.zhezye.aspectj;

import com.zhzye.aspectj.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PersonTest {
    @Resource(name = "person")
    Person person;

    @Test
    public void person() {
        person.hi();
        person.say();
    }
}
