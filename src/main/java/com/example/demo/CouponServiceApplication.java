package com.example.demo;

import com.example.demo.dao.CouponRepository;
import com.example.demo.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class CouponServiceApplication implements CommandLineRunner {

    private final CouponRepository couponRepository;

    @Autowired
    public CouponServiceApplication(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CouponServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        couponRepository.save(new Coupon("7d6869fc",11.0));
        couponRepository.save(new Coupon("41e9",10.0));
        couponRepository.save(new Coupon("1e1672",19.0));
        couponRepository.save(new Coupon("c95745",8.0));

    }
}
