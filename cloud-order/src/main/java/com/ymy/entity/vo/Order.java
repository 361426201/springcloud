package com.ymy.entity.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {

    private Integer id;


    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 订单价格
     */
    private BigDecimal oorderPrice;

    /**
     * 订单数量
     */
    private  Integer num;

    /**
     * 用户信息
     */
    private User user;
}
