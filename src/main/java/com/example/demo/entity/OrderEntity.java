package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "order_table")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "id",unique = true)
    private String id;
    @Column(name = "order_name")
    private String orderName;
    @Column(name = "order_price")
    private Double orderPrice;
}
