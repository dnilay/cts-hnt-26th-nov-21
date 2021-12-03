package com.example.myorderservice.service;

import com.example.myorderservice.dao.OrderDao;
import com.example.myorderservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order createOrder(Order order) {
        return orderDao.save(order);
    }
}
