package com.shah.productservice.controller;

import com.shah.productservice.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    List<Product> products = new ArrayList<>();

    {
        populateList();
    }
    @GetMapping("/{productId}")
    public List<Product> getProducts(@PathVariable("productId") int productId) {
        return products.stream()
                .filter(product -> product.getId() == productId)
                .toList();
    }

    private void populateList() {
        for (int i = 0; i < 20; i++) {
            Product p = new Product();
            p.setId(i);
            p.setName("product " + i);
            p.setPrice(((int) (Math.random() * 10 +1)) * 1000);
            products.add(p);
        }
    }

}
