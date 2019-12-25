package com.ymy.coulduser.controller;

import com.ymy.coulduser.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RefreshScope
@Slf4j
public class UserController {


    private static Map<Integer,User> map = new ConcurrentHashMap<Integer, User>();

    static {
        User user1 = new User();
        user1.setId(1);
        user1.setUserName("张三");
        user1.setAge(18);
        map.put(1,user1);
        User user2 = new User();
        user2.setId(2);
        user2.setUserName("李四");
        user2.setAge(20);
        map.put(2,user2);
    }

    @Value("${test.name}")
    private String name;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String getUserName(){

        return "hello："+name+"     人生总是起起落落落落落落落落落落落落落落落落落落落落落落落落落落落落落落落落！";
    }


    @GetMapping(value = "userInfo")
    public User getUserInfo(@RequestParam("userId") Integer userId){
        if(null == userId){
            log.info("用户id为空！");
            return null;
        }
        User user = map.get(userId);
        return user;
    }
}
