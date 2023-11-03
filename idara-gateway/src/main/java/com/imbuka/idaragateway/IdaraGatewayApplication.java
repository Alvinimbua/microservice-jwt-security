package com.imbuka.idaragateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IdaraGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdaraGatewayApplication.class, args);
    }

}
