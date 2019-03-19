package com.dly.dao;

import com.dly.pojo.Cart;

import java.util.List;

public interface CartDao {
    /**
     * 保存购物车数据
     * @param cart：购物车对象
     * @return
     */
    Boolean save(Cart cart);

    /**
     * 通过会员id，查询购物车数据
     * @param memberId：会员id
     * @return
     */
    List<Cart> findAllByCartMemberId(Integer memberId);

    /**
     * 通过相应的ID查询购物车
     * @param goodsId：商品ID
     * @param memberId：会员ID
     * @param orderStatus：订单状态
     * @return
     */
    Cart findByGoodsMemberOrder(Integer goodsId,Integer memberId,Integer orderStatus);

    /**
     * 更新操作
     * @param cart
     * @return
     */
    Boolean update(Cart cart);

    /**
     * 根据ID删除单个购物车记录
     * @param cart
     * @return
     */
    Boolean deleteCart(Cart cart);

    /**
     * 根据购物车ID查询购车记录
     * @param cartId
     * @return
     */
    Cart findCartId(Integer cartId);

    /**
     * 根据会员ID清空当前登录会员的所有购物车记录
     * @param cart
     * @return
     */
    Boolean deleteAllCart(Cart cart);

    /**
     * 根据会员ID更新对应的购物车中的数量
     * @param cart
     * @return
     */
    Boolean updateCartCount(Cart cart);

    /**
     * 提交表单时更新Cart表
     * @param cart
     * @return
     */
    Boolean updateCart(Cart cart);

    /**
     * 插入订单号
     *
     */
    Boolean insertCartCode(String code ,Integer member_id);
}
