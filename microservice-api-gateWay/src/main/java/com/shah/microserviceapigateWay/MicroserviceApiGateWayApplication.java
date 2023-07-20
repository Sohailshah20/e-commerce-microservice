package com.shah.microserviceapigateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApiGateWayApplication.class, args);
	}

}
