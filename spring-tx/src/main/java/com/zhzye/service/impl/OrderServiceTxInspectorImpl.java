package com.zhzye.service.impl;

import com.zhzye.dao.OrderDao;
import com.zhzye.dao.ProductDao;
import com.zhzye.entity.Order;
import com.zhzye.entity.Product;
import com.zhzye.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceTxInspectorImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public void saveOrder(final Order order, final List<Product> productList) {
        orderDao.saveOrder(order);
        for (Product product : productList) {
            productDao.saveProduct(product);
        }
    }
}
