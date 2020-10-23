package com.coupon.zuul.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zuorui
 * @creat 2020-10-23-16:01
 */
@Slf4j
@Component
public class AccessLogFilter extends AbstractZuulPostFilter{
    @Override
    protected Object crun() {
        HttpServletRequest request = context.getRequest();
        long startTime = (long) context.get("start time");
        long duration = System.currentTimeMillis() - startTime;
        String uri = request.getRequestURI();
        log.info("uri:{},duration:{}",uri,duration);
        return success();
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }
}
