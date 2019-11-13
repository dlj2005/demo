package com.example.demo.phoenix.mapper;

import com.example.demo.phoenix.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by hadoopuser on 11/1/19.
 */

@Repository
public interface OrderMapper {
    List<Order> getOrders();


    void updateOrder(@Param("id") Long id, @Param("totalAmount") BigDecimal totalAmount);
}
