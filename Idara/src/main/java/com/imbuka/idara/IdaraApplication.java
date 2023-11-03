package com.imbuka.idara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IdaraApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdaraApplication.class, args);
    }

}
