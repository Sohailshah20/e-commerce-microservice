package com.shah.orderservice.controller;

import com.shah.orderservice.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/order")
public class OrderController {
    List<Order> order = new ArrayList<>();
    {
        populateList();
        order.forEach(System.out::println);
    }
    @GetMapping("/{customerId}")
    public List<Order> getOrders(@PathVariable("customerId") int customerId){
        return order.stream()
                .filter(order -> order.getUserId() == customerId)
                .toList();
    }

    private void populateList() {
        for (int i = 0; i < 20; i++) {
            Order p = new Order();
            p.setProductId((int) (Math.random() * 20 +1));
            p.setUserId((int) (Math.random() * 5 +1));
            order.add(p);
        }
    }
}
