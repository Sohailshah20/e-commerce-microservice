package com.shah.customerservice.controller;

import com.shah.customerservice.model.CustomerInfo;
import com.shah.customerservice.model.Product;
import com.shah.customerservice.model.UserOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final WebClient.Builder webClient;

    public CustomerController(WebClient.Builder webClient) {
        this.webClient = webClient;
    }


    @GetMapping("/{customerId}")
    public CustomerInfo getCustomerInfo(@PathVariable("customerId") int customerId) {
        System.out.println("http://order-service/order/" + customerId);
        UserOrder userOrder = webClient.build()
                .get()
                .uri("http://order-service/order/" + customerId)
                .retrieve()
                .bodyToMono(UserOrder.class)
                .block();

        userOrder.getUserOrder().forEach(System.out::println);
        List<Product> productList = userOrder.getUserOrder().stream()
                .map(order -> webClient.build()
                        .get()
                        .uri("http://product-service/product/" + order.getProductId())
                        .retrieve()
                        .bodyToMono(Product.class)
                        .block())
                .toList();

        return new CustomerInfo(customerId, productList);
    }

}
