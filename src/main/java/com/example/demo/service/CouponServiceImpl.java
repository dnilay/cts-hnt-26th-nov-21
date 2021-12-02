package com.example.demo.service;

import com.example.demo.dao.CouponRepository;
import com.example.demo.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService{

    private final CouponRepository couponRepository;

    @Autowired
    public CouponServiceImpl(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public Coupon getCouponByCode(String couponCode) {
        return couponRepository.findByCouponCode(couponCode);
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }
}
