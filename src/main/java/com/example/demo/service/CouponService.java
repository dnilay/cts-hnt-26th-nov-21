package com.example.demo.service;

import com.example.demo.model.Coupon;

import java.util.List;

public interface CouponService {

    public Coupon getCouponByCode(String couponCode);

    public List<Coupon> getAllCoupons();
}
