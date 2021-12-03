package com.example.myorderservice.controller;

import com.example.myorderservice.model.Order;
import com.example.myorderservice.proxy.CouponProxy;
import com.example.myorderservice.service.OrderService;
import com.example.myorderservice.shared.Coupon;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {


    private final Environment environment;
    private final OrderService orderService;
    private final CouponProxy couponProxy;
    @Autowired
    public OrderController(Environment environment,OrderService orderService,CouponProxy couponProxy) {
        this.environment = environment;
        this.orderService = orderService;
        this.couponProxy=couponProxy;
    }
    @GetMapping("/status")
    public ResponseEntity<?> getStatus()
    {
        return ResponseEntity.ok("order-ws is up and running on port: "+environment.getProperty("local.server.port"));
    }

    @PostMapping
    @CircuitBreaker(name = "myCircuitBreaker",fallbackMethod = "myTestFallBack")
    public ResponseEntity<Order> createOrder(@RequestBody Order order)
    {
        Coupon coupon=couponProxy.getCouponByCouponCode(order.getCouponCode());
        order.setDiscountedPrice(order.getOrderPrice()-coupon.getDiscountAmount());
        Order tempOrder=orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(tempOrder);
    }

    public ResponseEntity<?> myTestFallBack(Exception e)
    {
        return ResponseEntity.ok("within myTestFallBack method. COUPON-WS is down"+e.toString());
    }
}
