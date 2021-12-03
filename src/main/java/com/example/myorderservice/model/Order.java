package com.example.myorderservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_table")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "order_name", nullable = false)
    private String orderName;
    @Column(name = "order_price")
    private Double orderPrice;
    @Column(name = "price_after_discount")
    private Double discountedPrice;
    @Transient
    private String couponCode;

}
