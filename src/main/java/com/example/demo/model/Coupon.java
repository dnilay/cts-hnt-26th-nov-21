package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity
@Table(name = "coupon_table")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coupon_id")
    private Integer couponId;
    @Column(name = "coupon_code",unique = true,nullable = false)
    private String couponCode;
    @Column(name = "discount_amount")
    private Double discountAmount;

    public Coupon(String couponCode, Double discountAmount) {
        this.couponCode = couponCode;
        this.discountAmount = discountAmount;
    }
}
