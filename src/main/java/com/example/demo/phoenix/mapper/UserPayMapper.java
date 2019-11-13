package com.example.demo.phoenix.mapper;

import com.example.demo.phoenix.entity.Order;
import com.example.demo.phoenix.entity.UserPay;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoopuser on 11/1/19.
 */

@Repository
public interface UserPayMapper {

    List<UserPay> getPayList(Map<String, Object> map);

//    void updateOrder(@Param("id") Long id, @Param("totalAmount") BigDecimal totalAmount);
}
