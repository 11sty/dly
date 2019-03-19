package com.dly.service;

import com.dly.dto.BaseDto;
import com.dly.pojo.Cart;

import java.util.List;

public interface CartService {
    /**
     * 添加购物车数据
     * @param cart：购物车对象
     * @return
     */
    BaseDto<Cart> addCard(Cart cart);

    /**
     * 购物车列表
     * @param memberId：会员ID
     * @return
     */
    List<Cart> cartList(Integer memberId);

    /**
     * 根据指定ID删除对应的单个购物车记录
     * @param cart
     * @return
     */
    BaseDto<Cart> delCart(Cart cart);

    /**
     * 根据会员ID删除对应的购物车记录
     * @param cart
     * @return
     */
    BaseDto<Cart> delAllCart(Cart cart);

    /**
     * 更新数量
     * @param cart
     * @return
     */
    BaseDto<Cart> updateCartCount(Cart cart);
}
