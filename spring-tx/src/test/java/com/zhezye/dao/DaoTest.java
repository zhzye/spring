package com.zhezye.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DaoTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void executeDdl() {
//        jdbcTemplate.update("drop table orders");
//        jdbcTemplate.update("drop table products");
        jdbcTemplate.update("create table orders(order_id bigint(20) not null auto_increment," +
                " order_name varchar(256) not null," +
                " created_at datetime not null default now()," +
                "primary key(order_id))");
        jdbcTemplate.update("create table products(product_id bigint(20) not null auto_increment," +
                " product_name varchar(256) not null," +
                " order_id bigint(20) not null," +
                " created_at datetime not null default now()," +
                "primary key(product_id))");
    }
}
