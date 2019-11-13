package com.example.demo;

import com.example.demo.phoenix.entity.Order;
import com.example.demo.phoenix.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by hadoopuser on 11/1/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisPhoenixApplicationTests {

    @Autowired
    private OrderMapper orderMapper;


    @Test
    public void testGetOrders() {
        List<Order> orders = orderMapper.getOrders();
        orders.forEach(System.out::println);
    }

//    @Test
//    public void testUpdateOrder() {
//        orderMapper.updateOrder(2L, BigDecimal.valueOf(88.8));
//    }
}
