package com.ymy.coulduser.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${spring.redis.port}")
    private String port;

    @RequestMapping(value = "/username",method = RequestMethod.GET)
    public String getUserName(){

        return "I'm 9527！ redis端口："+port;
    }
}
