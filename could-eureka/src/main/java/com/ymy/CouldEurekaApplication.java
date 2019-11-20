package com.ymy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //开启eureka的注解，一定要加这个注解，否者没有效果
public class CouldEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouldEurekaApplication.class, args);
    }

}
