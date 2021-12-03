package com.example.myorderservice.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Coupon {
    private Integer couponId;
    private String couponCode;
    private Double discountAmount;

}
