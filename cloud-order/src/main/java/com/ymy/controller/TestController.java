package com.ymy.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ymy.entity.vo.Order;
import com.ymy.entity.vo.User;
import com.ymy.feign.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Slf4j
@RefreshScope
public class TestController {


    @Value("${test.name}")
    private String name;

    private UserClient userClient;

    TestController(UserClient userClient){
        this.userClient = userClient;
    }

    @GetMapping(value = "/test")
    public String test(){

        return "hello："+name+"     人生总是起起落落落落落落落落落落落落落落落落落落落落落落落落落落落落落落落落！";
    }


    @GetMapping(value = "orderInfo")
    @HystrixCommand(fallbackMethod = "defaultBack")
    public Order getOrderInfo(){
        Order order = new Order();
        order.setId(1);
        order.setUserId(2);
        order.setOorderPrice(BigDecimal.valueOf(100l));
        order.setNum(2);

        User userInfo = userClient.getUserInfo(order.getUserId());
        if(null == userInfo){
            log.info("没有查询到用户信息");
        }
        order.setUser(userInfo);
        return order;
    }

    /**
     * 失败之后走这里
     * @return
     */
    public Order defaultBack(){
        log.info("请求cloud-user服务发生错误");
        Order order = new Order();
        order.setId(110);
        order.setUserId(120);
        order.setOorderPrice(BigDecimal.valueOf(1000l));
        order.setNum(20);
        return order;
    }
}
