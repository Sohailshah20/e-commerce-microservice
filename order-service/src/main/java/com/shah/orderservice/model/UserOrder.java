package com.shah.orderservice.model;

import java.util.List;

public class UserOrder {
    private List<Order> userOrder;
    public UserOrder() {
    }

    public UserOrder(List<Order> userOrder) {
        this.userOrder = userOrder;
    }

    public List<Order> getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(List<Order> userOrder) {
        this.userOrder = userOrder;
    }
}
