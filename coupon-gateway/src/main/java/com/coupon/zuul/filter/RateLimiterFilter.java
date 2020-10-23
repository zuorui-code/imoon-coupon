package com.coupon.zuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zuorui
 * @creat 2020-10-23-15:42
 */
@Slf4j
@Component
public class RateLimiterFilter extends AbstractZuulPreFilter{

    RateLimiter rateLimiter = RateLimiter.create(2.0);

    @Override
    protected Object crun() {
        HttpServletRequest request = context.getRequest();
        if (rateLimiter.tryAcquire()) {
            log.info("get token success");
            return success();
        }
        else{
            log.error("rate limit:{}",request.getRequestURL());
            return fail(402,"rate limit");
        }

    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
