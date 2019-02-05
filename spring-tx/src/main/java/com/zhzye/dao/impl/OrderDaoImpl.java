package com.zhzye.dao.impl;

import com.zhzye.dao.OrderDao;
import com.zhzye.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveOrder(Order order) {
        String sql = "insert into orders(order_name) values(?)";
        jdbcTemplate.update(sql, order.getOrderName());
    }
}
