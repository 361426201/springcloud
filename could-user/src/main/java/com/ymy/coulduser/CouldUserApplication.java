package com.ymy.coulduser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient   //开启eureka客户端注解
public class CouldUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouldUserApplication.class, args);
    }

}
