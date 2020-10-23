package com.coupon.zuul.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @author zuorui
 * @creat 2020-10-23-15:04
 */
public abstract class  AbstractZuulPostFilter extends AbstractZuulFilter{

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }
}
