package com.ymy.feign.hystrix;

import com.ymy.entity.vo.User;
import com.ymy.feign.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserClientHystrix  {

    public User getUserInfo(Integer userId) {
        //这里就是当远程调用失败时，feign会自动进入接口的实现类，就是之前所说的熔断，
        // 在这里，你可以做对应的处理，比如返回一个空的User对象，或者启用备用方案，调用联外一台服务等等。
        //这里我们直接返回空User对象
        log.info("请求cloud-user服务发生错误");
        return null;
    }
}
