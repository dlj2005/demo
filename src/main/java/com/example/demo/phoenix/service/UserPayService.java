package com.example.demo.phoenix.service;

import com.example.demo.phoenix.entity.Order;
import com.example.demo.phoenix.entity.UserPay;
import com.example.demo.phoenix.mapper.OrderMapper;
import com.example.demo.phoenix.mapper.UserPayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by hadoopuser on 11/2/19.
 */
@Service
public class UserPayService {
    @Autowired
    UserPayMapper userPayMapper;

    public List<UserPay> getPayList(Map<String, Object> map){
        return userPayMapper.getPayList(map);
    }
}
