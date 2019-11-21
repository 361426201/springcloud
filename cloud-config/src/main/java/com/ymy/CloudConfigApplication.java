package com.ymy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication  //springboot启动注解    相当于springboot1.5之前的：@SpringBootConfiguration + EnableAutoConfiguration + @ComponentScan
@EnableDiscoveryClient // 将服务注册到注册中心
@EnableConfigServer  //开启配置中心
public class CloudConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigApplication.class, args);
    }

}
