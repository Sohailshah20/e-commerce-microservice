package com.shah.productservice.controller;

import com.shah.productservice.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping("/product")
public class ProductController {

    List<Product> products = new ArrayList<>();

    {
        populateList();
        products.forEach(System.out::println);
    }
    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable("productId") int productId) {
        return products.stream()
                .filter(pro -> pro.getId() == productId)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.MULTI_STATUS,"Product not Found"));
    }

    private void populateList() {
        for (int i = 0; i <= 20; i++) {
            Product p = new Product();
            p.setId(i);
            p.setName("product " + i);
            p.setPrice(((int) (Math.random() * 10 +1)) * 1000);
            products.add(p);
        }
    }

}
