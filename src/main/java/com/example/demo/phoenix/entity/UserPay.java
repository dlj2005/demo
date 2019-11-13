package com.example.demo.phoenix.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by hadoopuser on 11/1/19.
 */
@Data
@ToString
@RequiredArgsConstructor
public class UserPay {
    private String shopId;
    private String createTime;
    private String userId;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserPay{" +
                "shopId='" + shopId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
