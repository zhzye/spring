package com.zhzye.dao.impl;

import com.zhzye.dao.ProductDao;
import com.zhzye.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveProduct(Product product) {
        String sql = "insert into products(product_name, order_id) values (?, ?)";
        jdbcTemplate.update(sql, product.getProductName(), product.getOrderId());
    }
}
