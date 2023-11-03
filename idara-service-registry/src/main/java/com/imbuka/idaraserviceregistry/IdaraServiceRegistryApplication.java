package com.imbuka.idaraserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class IdaraServiceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdaraServiceRegistryApplication.class, args);
    }

}
