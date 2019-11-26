package com.ymy.coulduser.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @RequestMapping(value = "/health",method = RequestMethod.GET)
    public String health(){
        System.out.println("进入了健康检查");

        return "I'm  OK";
    }
}
