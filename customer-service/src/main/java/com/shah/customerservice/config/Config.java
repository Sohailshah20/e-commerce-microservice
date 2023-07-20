package com.shah.customerservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {
    /*
    The @Load Balanced annotation tells teh webclient to get the original url from
    the eureka server and not directly go to the provided url.
    provided url: http://localhost/order-service/order/{customerId}
    original url: http://localhost/8002/order/{customerId}
    The webclient goes through the eureka server for every request fo find correct services.
     */
    @Bean
    @LoadBalanced
    public WebClient.Builder getWebClientBuilder(){
        return WebClient.builder();
    }

}
