package com.zhzye.aop;

import com.zhzye.aop.springway.Person;
import com.zhzye.aop.springway.PersonWithoutInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringAopTest {

//    @Resource(name = "person")
    @Resource(name = "personProxy")
    private Person person;

//    @Resource(name = "personWithoutInterface")
    @Resource(name = "personWithoutInterfaceProxy")
    private PersonWithoutInterface personWithoutInterface;

    @Test
    public void person() {
        person.eat();
        person.say();
    }

    @Test
    public void personWithoutInterface() {
        personWithoutInterface.eat();
        personWithoutInterface.say();
    }
}
