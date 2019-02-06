package com.zhzye.service;

import com.zhzye.entity.Order;
import com.zhzye.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextTxInspectorShortable.xml")
public class OrderServiceTxInspectorShortableTest {
    @Resource(name = "orderServiceTxInspectorImplProxy")
    private OrderService orderService;

    @Test
    public void saveOrder() {
        long orderId = (long) (Math.random() * 100000);
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            long productId = (long) (Math.random() * 100000);
            products.add(new Product("tx_inspector_shortable_product_" + productId, orderId));
        }

        orderService.saveOrder(new Order("tx_inspector_shortable_order_" + orderId), products);
    }
}
