package com.example.demo.dao;

import com.example.demo.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Integer> {
    @Query
    public Coupon findByCouponCode(String couponCode);
}
