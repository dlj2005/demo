package com.example.demo.phoenix.service;

import com.example.demo.phoenix.entity.Order;
import com.example.demo.phoenix.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hadoopuser on 11/2/19.
 */
@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    public List<Order> getOrders(){
        return orderMapper.getOrders();
    }
}
