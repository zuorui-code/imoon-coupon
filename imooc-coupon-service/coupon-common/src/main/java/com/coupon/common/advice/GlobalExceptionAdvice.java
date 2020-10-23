package com.coupon.common.advice;

import com.coupon.common.entity.CommonResponse;
import com.coupon.common.exception.CouponException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zuorui
 * @creat 2020-10-23-20:30
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = CouponException.class)
    public CommonResponse<String> HandleCouponException(HttpServletRequest httpServletRequest,
                                                        CouponException couponException){
        CommonResponse<String> response = new CommonResponse<>(-1,"business error");
        response.setData(couponException.getMessage());
        return response;
    }
}
