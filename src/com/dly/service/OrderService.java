package com.dly.service;

import com.dly.dto.BaseDto;
import com.dly.pojo.Cart;
import com.dly.pojo.Order;

import java.util.List;

public interface OrderService {

    BaseDto<Order> addOrderinfo(Order order);

    /**
     * 订单列表
     * @param memberId :会员ID
     * @return
     */
    List<Order> orderList(Integer memberId);

}
