package com.zhzye.service.impl;

import com.zhzye.dao.OrderDao;
import com.zhzye.dao.ProductDao;
import com.zhzye.entity.Order;
import com.zhzye.entity.Product;
import com.zhzye.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class OrderServiceTxTemplateImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public void saveOrder(final Order order, final List<Product> productList) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                try {
                    orderDao.saveOrder(order);
                    for (Product product : productList) {
                        productDao.saveProduct(product);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    transactionStatus.setRollbackOnly();
                }
                return null;
            }
        });
    }
}
