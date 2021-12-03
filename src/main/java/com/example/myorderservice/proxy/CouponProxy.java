package com.example.myorderservice.proxy;

import com.example.myorderservice.shared.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "COUPON-WS")
public interface CouponProxy {

    @GetMapping("/coupons/{couponCode}")
    public Coupon getCouponByCouponCode(@PathVariable("couponCode") String couponCode);
}
