package com.dly.dao;

import com.dly.pojo.Cart;
import com.dly.pojo.Order;

import java.util.List;

public interface OrderDao {
    /**
     * 更新code操作
     * @param order
     * @return
     */
    Boolean updateOrderCode(Order order);

    String findOrderCode(Integer member_id);

    /**
     * 根据会员id查询会员订单
     * @param memberId : 会员id
     * @return
     */
    List<Order> findAllOrderByMemberId(Integer memberId);

}
