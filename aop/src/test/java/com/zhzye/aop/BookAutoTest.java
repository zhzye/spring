package com.zhzye.aop;

import com.zhzye.aop.auto.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class BookAutoTest {
    @Autowired
    private Book book;

    @Test
    public void hi() {
        book.hi();
        book.say();
    }
}
