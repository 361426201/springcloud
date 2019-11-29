package com.ymy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope
public class TestController {


    @Value("${test.name}")
    private String name;

    @GetMapping(value = "/test")
    public String test(){

        return "hello："+name+"     人生总是起起落落落落落落落落落落落落落落落落落落落落落落落落落落落落落落落落！";
    }
}
