package com.ymy.feign;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ymy.entity.vo.User;
import com.ymy.feign.hystrix.UserClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cloud-user"/*,fallback = UserClientHystrix.class*/)
public interface UserClient {

    @GetMapping(value = "userInfo")
    User getUserInfo(@RequestParam("userId") final Integer userId);
}
