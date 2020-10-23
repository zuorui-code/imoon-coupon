package com.coupon.zuul.filter;

/**
 * @author zuorui
 * @creat 2020-10-23-15:56
 */
public class PreRequsetFilter extends AbstractZuulPreFilter{
    @Override
    protected Object crun() {


        context.set("start time",System.currentTimeMillis());
        return success();
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
