package com.zhzye.entity;

import java.util.Date;

public class Order {
    private Long orderId;
    private String orderName;
    private Date createdAt;

    public Order(String orderName) {
        this.orderName = orderName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
