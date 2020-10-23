package com.coupon.zuul.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpRequest;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zuorui
 * @creat 2020-10-23-15:12
 */
@Component
@Slf4j
public class TokenFilter extends AbstractZuulPreFilter{


    @Override
    protected Object crun() {
        HttpServletRequest request = context.getRequest();
        log.info(String.format("%s request %s",request.getMethod(),request.getRequestURL().toString()));
        Object token = request.getParameter("token");
        if (token == null) {

            log.error("token is empty");
            return fail(404,"token is empty");
        }
        return success();
    }

    @Override
    public int filterOrder() {
        return 1;
    }
}
