package com.ymy.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

@Component
@Slf4j
public class MyFilter extends ZuulFilter {

    private static final RateLimiter RATE_LIMITER = RateLimiter.create(1000);
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SIMPLE_HOST_ROUTING_FILTER_ORDER -1;
    }

    /**
     * 判断哪些请求需要校验，哪些请求直接放行
     * true：需要校验    false：直接放行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        //我这里模拟一下   请求uri携带nofilter的直接放行  否者需要校验
        if( ctx.getRequest().getRequestURI().indexOf("nofilter") != -1){
            //放行
            return false;
        }
        //进入run方法进行校验
        return true;
    }


    /**
     * 执行校验的方法
     * 返回null表示放行
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        log.info("校验开始==========>");

        log.info("放行=========>");
        return null;
    }
}
