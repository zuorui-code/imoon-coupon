package com.coupon.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.xml.transform.Result;

/**
 * @author zuorui
 * @creat 2020-10-23-14:11
 */
public abstract class AbstractZuulFilter extends ZuulFilter {

    RequestContext context;
    private final static String NEXT = "next";


    @Override
    public boolean shouldFilter() {

        RequestContext cxt = RequestContext.getCurrentContext();
        return (boolean) cxt.getOrDefault("next",true);

    }

    @Override
    public Object run() throws ZuulException {
        context = RequestContext.getCurrentContext();
        return crun();
    }
    protected  abstract Object crun();
    Object fail(int code,String msg) {
        context.set(NEXT,false);
        context.setSendZuulResponse(false);
        context.getResponse().setContentType("text/html,charest = utf-8");
        context.setResponseStatusCode(code);
        context.setResponseBody(String.format("{\"Result\":\"%s!\"}",msg));
        return null;
    }

    Object success() {
        context.set(NEXT,true);
        return null;
    }
}
