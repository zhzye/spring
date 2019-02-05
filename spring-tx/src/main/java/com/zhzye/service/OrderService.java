package com.zhzye.service;

import com.zhzye.entity.Order;
import com.zhzye.entity.Product;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order, List<Product> productList);
}
