package com.zhzye.service.impl;

import com.zhzye.dao.OrderDao;
import com.zhzye.dao.ProductDao;
import com.zhzye.entity.Order;
import com.zhzye.entity.Product;
import com.zhzye.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private TransactionDefinition transactionDefinition;

    public void saveOrder(Order order, List<Product> productList) {
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        try {
            orderDao.saveOrder(order);
            for (Product product : productList) {
                productDao.saveProduct(product);
            }
            platformTransactionManager.commit(transactionStatus);
        } catch (Exception e) {
            platformTransactionManager.rollback(transactionStatus);
            e.printStackTrace();
        }
    }
}
