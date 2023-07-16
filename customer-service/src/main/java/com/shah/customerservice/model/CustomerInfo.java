package com.shah.customerservice.model;

import java.util.List;

public class CustomerInfo {
    private int customerId;
    private List<Product> product;

    public CustomerInfo(){}

    public CustomerInfo(int customerId, List<Product> product) {
        this.customerId = customerId;
        this.product = product;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
