package com.example.demo.controller;

import com.example.demo.model.Coupon;
import com.example.demo.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupons")
@CrossOrigin(origins = "*")
public class CouponController {

    private final CouponService couponService;

    @Autowired
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }
    @GetMapping("/{couponCode}")
    public Coupon findCoupon(@PathVariable("couponCode") String couponCode) {
        return couponService.getCouponByCode(couponCode);
    }

    @GetMapping
    public List<Coupon> fetchAll()
    {
        return couponService.getAllCoupons();
    }
}
