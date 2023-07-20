package com.shah.microserviceapigateWay;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @RequestMapping("/orderFallBack")
    public Mono<String> orderServiceFallback(){
        return Mono.just("Order service took to long to respond. Try again later");
    }

    @RequestMapping("/customerFallBack")
    public Mono<String> customerServiceFallback(){
        return Mono.just("customer service took to long to respond. Try again later");
    }

    @RequestMapping("/productFallBack")
    public Mono<String> productServiceFallback(){
        return Mono.just("product service took to long to respond. Try again later");
    }
}
