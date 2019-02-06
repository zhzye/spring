package com.zhzye.service;

import com.zhzye.entity.Order;
import com.zhzye.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTxTemplate.xml")
public class OrderServiceTxTemplateTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void saveOrder() {
        long orderId = (long) (Math.random() * 100000);
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            long productId = (long) (Math.random() * 100000);
            products.add(new Product("product_" + productId, orderId));
        }

        orderService.saveOrder(new Order("order_" + orderId), products);
    }
}
